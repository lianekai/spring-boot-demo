package com.lianekai.caffeine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

/**
 * SpringBoot 集成Caffeine Cache Demo
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/01/23 13:23
 */
@SpringBootApplication
@EnableCaching
public class CaffeineCacheApplication {
    public static void main(String[] args) {
        //启动
        SpringApplication.run(CaffeineCacheApplication.class,args);
    }
}
