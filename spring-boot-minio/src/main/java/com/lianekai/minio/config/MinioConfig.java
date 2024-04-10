package com.lianekai.minio.config;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.Assert;

/**
 * minio配置类
 *
 * @author lianyikai
 * @date 2023/12/1 10:12
 */
@Configuration
public class MinioConfig {
    @Value("${minio.minioServerUrl}")
    private String minioServerUrl;
    @Value("${minio.minioUser}")
    private String minioUser;
    @Value("${minio.minioPassword}")
    private String minioPassword;
    @Value("${minio.minioBucket}")
    private String minioBucket;

    @Bean
    public MinioClient minioClient() throws Exception {

        Assert.notNull(minioServerUrl, "Minio服务地址不能为空！");
        Assert.notNull(minioUser, "Minio用户名不能为空！");
        Assert.notNull(minioPassword, "Minio密码不能为空！");
        Assert.notNull(minioBucket, "Minio存储桶不能为空！");

        MinioClient minioClient = MinioClient.builder()
                .endpoint(minioServerUrl)
                .credentials(minioUser, minioPassword)
                .build();

        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(minioBucket).build());
        if (!exists) {
            // 文件桶不存在则创建
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(minioBucket).build());
        }
        return minioClient;
    }
}
