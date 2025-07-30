package com.lianekai.mybatisplus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author lianyikai
 * @date 2025年07月13日 10:44
 */
@SpringBootApplication(scanBasePackages = "com.lianekai.mybatisplus")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);

    }
}
