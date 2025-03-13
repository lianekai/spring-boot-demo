package com.lianekai.big.data.service;

import org.apache.spark.sql.Dataset;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SparkSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * SparkService
 *
 * @author lianyikai
 * @date 2025/3/10 18:42
 */
@Service
public class SparkService {

    @Autowired
    private SparkSession sparkSession;

    public void processData() {
        Dataset<Row> df = sparkSession.read().json("path/to/data.json");
        df.show();
    }
}
