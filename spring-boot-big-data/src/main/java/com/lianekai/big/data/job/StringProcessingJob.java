package com.lianekai.big.data.job;

import org.apache.flink.streaming.api.datastream.DataStream;
import org.apache.flink.streaming.api.environment.StreamExecutionEnvironment;

/**
 * StringProcessingJob
 *
 * @author lianyikai
 * @date 2025/3/10 18:41
 */
public class StringProcessingJob {

    public static void main(String[] args) throws Exception {
        StreamExecutionEnvironment env = StreamExecutionEnvironment.getExecutionEnvironment();
        DataStream<String> text = env.fromElements("Hello", "Flink", "Spring Boot");
        DataStream<String> processedText = text.map(value -> "Processed: " + value);
        processedText.print();
        env.execute("String Processing Job");
    }
}
