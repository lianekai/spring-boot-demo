package com.lianekai.es.util;

import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * ElasticSearchUtils工具类
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/14 10:20
 */
@Slf4j
public class ElasticSearchUtils {

    public static Boolean creatIndex(String index) throws IOException {
        RestHighLevelClient restHighLevelClient= SpringUtil.getBean(RestHighLevelClient.class);
        GetIndexRequest getIndexRequest = new GetIndexRequest(index);
        /**判断索引存不存在*/
        Boolean existIndex=restHighLevelClient.indices().exists(getIndexRequest, RequestOptions.DEFAULT);
        /**不存在则创建index和setting mapping*/
        if(!existIndex){
            CreateIndexRequest  createIndexRequest=new CreateIndexRequest(index);
            Settings settings = Settings.builder()
                    .put("index.number_of_shards",1)
                    .put("index.number_of_replicas",1)
                    .build();
            createIndexRequest.settings(settings);
            CreateIndexResponse createIndexResponse = restHighLevelClient.indices().create(createIndexRequest,RequestOptions.DEFAULT);
            if (!createIndexResponse.isAcknowledged()) {
                log.error(">>>> 创建索引和映射关系失败! <<<<");
                throw new RuntimeException("创建索引和映射关系失败!");
            }
            return Boolean.TRUE;
        }
        return Boolean.TRUE;
    }

    /***
     * 添加文档(使用XContentBuilder 构建内容方式)
     *
     * @param index 添加到哪个索引
     * @return
     * @version: 1.0
     * @date: 2021/12/14 18:01
     * @author: yikai.lian
     */
    public static Boolean addDoc(String index) throws IOException {
        RestHighLevelClient restHighLevelClient= SpringUtil.getBean(RestHighLevelClient.class);
        XContentBuilder builder= XContentFactory.jsonBuilder();
        builder.startObject();
        {
            builder.field("user","练益楷");
            builder.timeField("createdTime",new Date());
            builder.field("message","测试提交......");
        }
        builder.endObject();

        IndexRequest request = new IndexRequest(index).id("1").source(builder);
        IndexResponse indexResponse = restHighLevelClient.index(request, RequestOptions.DEFAULT);
        return Boolean.TRUE;

    }




}
