package com.lianekai.minio.service.impl;

import com.lianekai.minio.service.FileService;
import io.minio.*;
import io.minio.messages.Item;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * minio 文件服务
 *
 * @author lianyikai
 * @date 2023/12/1 10:24
 */
@Slf4j
@Service
public class MinioFileServiceImpl implements FileService {
    
    @Resource
    private MinioClient minioClient;

    @Value("${minio.minioServerUrl}")
    private String minioServerUrl;
    @Value("${minio.minioBucket}")
    private String minioBucket;

    @Override
    public boolean upload(MultipartFile file, String filePath) {
        boolean bool = true;
        try {
            // 文件上传
            minioClient.putObject(PutObjectArgs.builder()
                    .stream(file.getInputStream(), file.getSize(), PutObjectArgs.MIN_MULTIPART_SIZE)
                    .object(filePath)
                    // 文件类型为jpg图片类型
                    .contentType(MediaType.IMAGE_JPEG_VALUE)
                    .bucket(minioBucket)
                    .build()).etag();
        } catch (Exception e) {
            bool = false;
            log.error("文件统一异常：{}", e.getLocalizedMessage());
        }
        return bool;
    }

    @Override
    public boolean upload(InputStream in, String filePath) {
        boolean bool = false;
        try {
            // 文件上传
            String etag = minioClient.putObject(PutObjectArgs.builder()
                    .stream(in, in.available(), PutObjectArgs.MIN_MULTIPART_SIZE)
                    .object(filePath)
                    // 文件类型为jpg图片类型
                    .contentType(MediaType.IMAGE_JPEG_VALUE)
                    .bucket(minioBucket)
                    .build()).etag();
            if (StringUtils.isNotBlank(etag)) {
                bool = true;
                log.info("文件上传成功 {} ", filePath);
            }
        } catch (Exception e) {
            log.error("文件统一异常：{}", e.getLocalizedMessage());
        }
        return bool;
    }

    @Override
    public boolean delete(String filePath) {
        boolean bool = true;
        try {
            minioClient.removeObject(RemoveObjectArgs.builder()
                    .bucket(minioBucket)
                    .object(filePath)
                    .build());
        } catch (Exception e) {
            bool = false;
            log.error("minio文件删除失败", e);
        }
        return bool;
    }

    @Override
    public void download(String filePath, HttpServletResponse response, String responseName) {
        download(minioBucket, filePath, response, responseName);
    }

    @Override
    public void download(String bucketname, String filePath, HttpServletResponse response, String responseName) {
        InputStream in = null;
        try {
            StatObjectResponse statObjectResponse = minioClient.statObject(StatObjectArgs.builder().bucket(bucketname).object(filePath).build());
            response.setContentType(statObjectResponse.contentType());
            response.setCharacterEncoding("UTF-8");
            response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(responseName, String.valueOf(StandardCharsets.UTF_8)));
            in = minioClient.getObject(GetObjectArgs.builder().bucket(bucketname).object(filePath).build());
            IOUtils.copy(in, response.getOutputStream());
        } catch (Exception e) {
            log.error("minio文件失败", e);
        } finally {
            if (null != in) {
                try {
                    in.close();
                } catch (IOException e) {
                    log.error("minio文件失败", e);
                }
            }
        }
    }

    @Override
    public void downloadZip(List<String> filePathLst, HttpServletResponse response, String zipName) {
        File zipFile = null;
        OutputStream out = null;
        FileInputStream zipInput = null;
        try {
            String zip = zipName + ".zip";
            response.setContentType("application/zip;charset=utf-8");
            response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(zip, String.valueOf(StandardCharsets.UTF_8)));

            zipFile = new File(zip);
            ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));
            byte[] buf = new byte[1024 * 8];
            for (String filePath : filePathLst) {
                File file = new File(filePath);
                ZipEntry entry = new ZipEntry(file.getName());
                zipOut.putNextEntry(entry);
                //注意以什么编码存就要以什么编码取，否则读取不到文件
                InputStream in = minioClient.getObject(GetObjectArgs.builder()
                        .bucket(minioBucket)
                        .object(filePath)
                        .build());
                if (null != in) {
                    int n;
                    while (-1 != (n = in.read(buf))) {
                        zipOut.write(buf, 0, n);
                    }
                    zipOut.closeEntry();
                    in.close();
                }
            }
            zipOut.close();
            //下载
            int len;
            zipInput = new FileInputStream(zipFile);
            out = response.getOutputStream();
            while ((len = zipInput.read(buf)) != -1) {
                out.write(buf, 0, len);
            }
        } catch (Exception e) {
            log.error("文件下载压缩：{}", e.getLocalizedMessage());
        } finally {
            try {
                if (null != zipInput) {
                    zipInput.close();
                }
                if (null != out) {
                    out.flush();
                    out.close();
                }
                if (null != zipFile) {
                    //删除压缩包
                    boolean delete = zipFile.delete();
                    log.info("删除是否成功：{}", delete);
                }
            } catch (Exception e) {
                log.error("minio文件失败", e);
            }
        }
    }

    @Override
    public List<String> getFileList(String filePath) {
        return getFileList(filePath, true);
    }

    @Override
    public List<String> getFileList(String filePath, boolean isAllPath) {
        List<String> fileLst = new ArrayList<>();
        try {
            // 判断桶是否存在
            boolean bucketExists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioBucket).build());
            if (!bucketExists) {
                log.error(minioBucket + "文件桶不存在");
                return fileLst;
            }
            Iterable<Result<Item>> results = minioClient.listObjects(
                    ListObjectsArgs.builder()
                            .bucket(minioBucket)
                            .prefix(filePath)
                            .recursive(true).build());
            for (Result<Item> rst : results) {
                Item item = rst.get();
                if (StringUtils.isNotBlank(item.objectName())) {
                    if (isAllPath) {
                        fileLst.add(minioServerUrl + "/" + minioBucket + "/" + item.objectName());
                    } else {
                        fileLst.add("/" + item.objectName());
                    }
                }
            }
        } catch (Exception e) {
            log.error("文件获取异常：{}", e.getLocalizedMessage());
        }
        return fileLst;
    }

    @Override
    public List<String> getFileNameLst(String filePath) {
        List<String> files = getFileList(filePath);
        for (int i = 0; i < files.size(); i++) {
            String file = files.get(i);
            int idx = file.lastIndexOf("/");
            if (idx > -1) {
                files.set(i, file.substring(idx + 1));
            }
        }
        return files;
    }

    @Override
    public InputStream getInputStream(String filePath) {
        InputStream in = null;
        try {
            in = minioClient.getObject(GetObjectArgs.builder()
                    .bucket(minioBucket)
                    .object(filePath)
                    .build());
        } catch (Exception e) {
            log.error(filePath + "文件不存在", e);
        }
        return in;
    }
}
