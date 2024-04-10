package com.lianekai.minio.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.List;


/**
 * @author 盛视科技
 * @date 2023/12/01
 */
public interface FileService {

    /**
     * 文件上传
     *
     * @param file     文件流
     * @param filePath 文件存储地址
     * @return 布尔（成功/失败）
     */
    boolean upload(MultipartFile file, String filePath);

    /**
     * 文件上传
     *
     * @param in       文件流
     * @param filePath 文件存储地址
     * @return 布尔（成功/失败）
     */
    boolean upload(InputStream in, String filePath);

    /**
     * 删除文件
     *
     * @param filePath 文件所属路径,如果是文件名则模糊删除
     * @return 布尔（成功/失败）
     */
    boolean delete(String filePath);

    /**
     * 文件下载
     *
     * @param filePath     文件路径
     * @param response     返回流
     * @param responseName 下载文件名
     */
    void download(String filePath, HttpServletResponse response, String responseName);

    /**
     * 文件下载（指定桶名）
     *
     * @param bucketName   文件桶
     * @param filePath     文件路径
     * @param response     返回流
     * @param responseName 下载文件名
     */
    void download(String bucketName, String filePath, HttpServletResponse response, String responseName);

    /**
     * 下载文件zip压缩包
     *
     * @param filePathLst 文件路径集合
     * @param response    返回流
     * @param zipName     压缩包名称
     */
    void downloadZip(List<String> filePathLst, HttpServletResponse response, String zipName);

    /**
     * 获取文件夹下的所有文件集合（全路径）
     *
     * @param filePath 文件路径
     * @return List<String> 文件集合
     */
    List<String> getFileList(String filePath);

    /**
     * 获取文件列表
     * @param filePath
     * @param isAllPath
     * @return {@link List}<{@link String}>
     */
    List<String> getFileList(String filePath, boolean isAllPath);

    /**
     * 获取文件夹下的所有文件名（文件名）
     *
     * @param filePath 文件路径
     * @return List<String> 集合
     */
    List<String> getFileNameLst(String filePath);

    /**
     * 获取文件流
     *
     * @param filePath 文件路径
     * @return InputStream 文件流
     */
    InputStream getInputStream(String filePath);
}
