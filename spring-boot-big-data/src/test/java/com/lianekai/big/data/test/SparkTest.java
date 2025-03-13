package com.lianekai.big.data.test;

import com.lianekai.big.data.BigDataApplication;
import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * SparkTest
 *
 * @author lianyikai
 * @date 2025/3/13 09:51
 */
@SpringBootTest(classes = BigDataApplication.class)
public class SparkTest {
    @Autowired
    private SparkSession sparkSession;

    @Test
    public void test() {

        // 从 ClickHouse 读取数据
        Dataset<Row> df = sparkSession.read()
                .format("jdbc")
                .option("url", "jdbc:clickhouse://localhost:8123/default")
                .option("dbtable", "customs_data") // 替换为你的表名
                .option("user", "default")
                .option("password", "123456")
                .load();

        // 显示数据
        df.show();

        // 进行分析（示例：计算某列的平均值）
        df.groupBy("trade_value").avg().show(); // 替换为你的列名

        // 停止 SparkSession
        sparkSession.stop();
    }
}
