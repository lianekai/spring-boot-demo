package com.lianekai.sharding;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author lyk
 * @version: 1.0
 * @date 10:13
 */
@SpringBootApplication
@EnableTransactionManagement(proxyTargetClass = true)
@MapperScan("com.lianekai.sharding.mapper")
public class ShardingSphereApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShardingSphereApplication.class,args);
    }
}
