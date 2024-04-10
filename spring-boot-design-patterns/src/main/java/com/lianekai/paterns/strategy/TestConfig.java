package com.lianekai.paterns.strategy;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.Resource;

/**
 * todo
 *
 * @author lianyikai
 * @date 2023/11/20 23:43
 */
@Configuration
public class TestConfig {

    @Resource
    TaskContext context;

    @Bean
    public void test(){
        context.handle("task1Handler");
    }
}
