package com.lianekai.spark.job;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.stereotype.Component;

/**
 * SparkJob
 *
 * @author lianyikai
 * @date 2025/3/13 14:33
 */
@Component
public class SparkJob {

    public void run() {
        // 初始化SparkSession
        SparkSession spark = SparkSession.builder()
                .appName("SpringBootSparkIntegration")
                .master("spark://localhost:7077") // 连接到Docker中的Spark Master
                .getOrCreate();

        // 创建一个简单的DataFrame
        Dataset<Row> data = spark.range(10).toDF("number");

        // 执行一些简单的操作
        Dataset<Row> result = data.selectExpr("number", "number * 2 as doubled");

        // 显示结果
        result.show();

        // 停止SparkSession
        spark.stop();
    }
}