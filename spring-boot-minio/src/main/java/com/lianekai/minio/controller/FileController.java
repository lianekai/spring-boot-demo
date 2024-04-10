package com.lianekai.minio.controller;


import com.lianekai.minio.service.FileService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 文件服务
 *
 * @author Wei Chen
 * @date 2023/7/18
 */
@RestController
@RequestMapping("file")
public class FileController {

    @Resource
    private FileService fileService;

    @GetMapping("download")
    public void download(HttpServletResponse response, String filePath, String responseName) {
        if (StringUtils.isBlank(responseName)) {
            Path path = Paths.get(filePath);
            responseName = path.getFileName().toString();
        }
        fileService.download(filePath, response, responseName);
    }

    @PostMapping("upload")
    public void upload(@RequestParam("file") MultipartFile file) {
        fileService.upload(file, "20231204/test");
    }
}
