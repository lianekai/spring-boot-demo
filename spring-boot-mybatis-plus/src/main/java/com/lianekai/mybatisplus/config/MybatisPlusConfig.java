package com.lianekai.mybatisplus.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianyikai
 * @date 2025年07月13日 10:50
 */
@Configuration
@MapperScan("com.lianekai.mybatisplus.mapper") //指定扫描路径才能把 Mapper 注入到 容器
public class MybatisPlusConfig {
}
