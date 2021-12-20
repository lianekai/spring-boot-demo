package com.lianekai.doc.config;

import com.lianekai.doc.spring.initializingbean.Bean1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 14:56
 */
@Configuration
public class BeanConfig {

    @Bean
    public Bean1 getBean1(){
        return new Bean1();
    }
}
