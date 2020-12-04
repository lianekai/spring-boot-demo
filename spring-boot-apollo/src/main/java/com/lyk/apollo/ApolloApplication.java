package com.lyk.apollo;

import com.ctrip.framework.apollo.spring.annotation.EnableApolloConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author lyk
 * @version: 1.0
 * @date 18:17
 */
@SpringBootApplication
@Slf4j
@EnableApolloConfig
public class ApolloApplication {
    public static void main(String[] args) {
        SpringApplication.run(ApolloApplication.class,args);
        log.info("application web started.");
    }
}
