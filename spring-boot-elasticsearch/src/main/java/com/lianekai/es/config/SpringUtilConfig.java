package com.lianekai.es.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * 将hutool工具类下的包注册到springBean容器中
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/14 11:40
 */
@Configuration
@ComponentScan(basePackages={"cn.hutool.extra.spring"})
public class SpringUtilConfig {
}
