package com.lianekai.big.data.config;

import org.apache.spark.sql.SparkSession;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Sark 配置
 *
 * @author lianyikai
 * @date 2025/3/10 18:30
 */
@Configuration
public class SparkConfig {
    @Bean
    public SparkSession sparkSession() {
        return SparkSession.builder()
                .appName("ClickHouse Analysis")
                .master("spark://localhost:7077")
                .getOrCreate();
    }
}
