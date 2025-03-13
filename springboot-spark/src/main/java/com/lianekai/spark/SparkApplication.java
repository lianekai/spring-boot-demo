package com.lianekai.spark;

import com.lianekai.spark.job.SparkJob;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * SparkApplication
 *
 * @author lianyikai
 * @date 2025/3/13 14:32
 */
@SpringBootApplication
public class SparkApplication implements CommandLineRunner {

    @Autowired
    private SparkJob sparkJob;

    public static void main(String[] args) {
        // 忽略非法反射警告  适用于jdk11
        System.setProperty("com.sun.xml.bind.v2.bytecode.ClassTailor.noOptimize", "true");
        SpringApplication.run(SparkApplication.class,args);
    }

    @Override
    public void run(String... args) throws Exception {
        sparkJob.run();
    }
}
