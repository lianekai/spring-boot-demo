package com.lianekai.es.config;

import org.apache.http.HttpHost;
import org.apache.http.HttpResponse;
import org.apache.http.nio.protocol.HttpAsyncResponseConsumer;
import org.elasticsearch.client.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * ElasticSearchConfig
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/13 14:53
 */
@Configuration
public class ElasticSearchConfig {
    public static final RequestOptions COMMON_OPTIONS;

    static {
        RequestOptions.Builder builder=RequestOptions.DEFAULT.toBuilder();
        /**这种是没有添加安全校验的*/
        /**这里如果ES有添加安全认证需要用到*/
//        builder.addHeader("Authorization","Bearer "+TOKEN);
//        builder.setHttpAsyncResponseConsumerFactory(
//                new HttpAsyncResponseConsumerFactory.HeapBufferedResponseConsumerFactory(30*1024*1024*1024)
//        );
        COMMON_OPTIONS=builder.build();
    }

    @Bean
    public RestHighLevelClient esRestClient() {
        return new RestHighLevelClient(
                RestClient.builder(
                        new HttpHost("81.71.135.210", 9200, "http")
                )
        );
    }
}
