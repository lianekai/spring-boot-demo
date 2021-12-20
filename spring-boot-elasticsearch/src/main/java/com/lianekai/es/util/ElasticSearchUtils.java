package com.lianekai.es.util;

import cn.hutool.extra.spring.SpringUtil;
import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.bulk.BulkRequest;
import org.elasticsearch.action.bulk.BulkResponse;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.ActiveShardCount;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.action.update.UpdateRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.indices.CreateIndexRequest;
import org.elasticsearch.client.indices.CreateIndexResponse;
import org.elasticsearch.client.indices.GetIndexRequest;
import org.elasticsearch.common.Strings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.common.xcontent.XContentFactory;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.index.VersionType;
import org.elasticsearch.search.fetch.subphase.FetchSourceContext;

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

    /***
     * 获取文档
     *
     * @return
     * @version: 1.0
     * @date: 2021/12/17 16:10
     * @author: yikai.lian
     */
    public static void getDoc(String index,String id) throws IOException {
        RestHighLevelClient restHighLevelClient= SpringUtil.getBean(RestHighLevelClient.class);
        GetRequest getRequest=new GetRequest(index,id);
        /**禁用源检索 默认启用*/
        getRequest.fetchSourceContext(FetchSourceContext.DO_NOT_FETCH_SOURCE);

        String[] includes=new String[]{"message","user","createdTime"};
        String[] excludes= Strings.EMPTY_ARRAY;

        FetchSourceContext fetchSourceContext=new FetchSourceContext(true,includes,excludes);
        getRequest.fetchSourceContext(fetchSourceContext);

        getRequest.storedFields("message"); //配置特定存储字段的检索(要求字段在映射中单独存储)

        GetResponse getResponse = restHighLevelClient.get(getRequest, RequestOptions.DEFAULT);

//        String message = getResponse.getField("message").getValue(); //检索消息存储字段(要求该字段单独存储在映射中)
        Map<String, Object> map=getResponse.getSource();

        String message2=(String)getResponse.getSource().get("message");

        getRequest.routing("routing"); //路由值

        getRequest.preference("preference"); //偏好值

        getRequest.realtime(false); //将realtime标志设置为false

        getRequest.refresh(true); //在检索文档之前执行刷新(默认为false)

        getRequest.version(2); //版本

        getRequest.versionType(VersionType.EXTERNAL); //版本类型

        log.info(message2);

    }

    public static void bulkRequest() throws IOException {
        RestHighLevelClient restHighLevelClient= SpringUtil.getBean(RestHighLevelClient.class);
        /** BulkRequest可用于使用单个请求执行多个索引、更新和/或删除操作。*/
        BulkRequest bulkRequest=new BulkRequest();
        bulkRequest.add(new IndexRequest("log").id("1")
                .source(XContentType.JSON,"field", "foo"));//将第一个索引请求添加到批量请求中
        bulkRequest.add(new IndexRequest("log").id("2")
                .source(XContentType.JSON,"field", "bar"));//添加第二个索引请求
        bulkRequest.add(new IndexRequest("log").id("3")
                .source(XContentType.JSON,"field", "baz"));//添加第三个索引请求


        /** Bulk API只支持JSON或SMILE中编码的文档。以任何其他格式提供文档都将导致错误。*/
//        bulkRequest.add(new DeleteRequest("log3", "3")); //向批量请求添加删除请求
//        bulkRequest.add(new UpdateRequest("log3", "2")
//                .doc(XContentType.JSON,"other", "test"));//向批量请求添加更新请求。
//        bulkRequest.add(new IndexRequest("log3").id("4")
//                .source(XContentType.JSON,"field", "baz"));//使用SMILE格式添加索引请求

        bulkRequest.timeout(TimeValue.timeValueMinutes(2)); //设置超时时间
//        bulkRequest.timeout("2m"); //设置超时时间
        bulkRequest.setRefreshPolicy(WriteRequest.RefreshPolicy.WAIT_UNTIL); //WriteRequest.RefreshPolicy实例形式设置刷新策略
//        bulkRequest.setRefreshPolicy("wait_for"); //字符串形式设置刷新策略
        bulkRequest.waitForActiveShards(2); //设置在继续索引/更新/删除操作之前必须活动的碎片副本的数量。
        bulkRequest.waitForActiveShards(ActiveShardCount.ALL); //作为动态硬装载提供的碎片副本数，可选：ActiveShardCount.ALL, ActiveShardCount.ONE或 ActiveShardCount.DEFAULT
        bulkRequest.pipeline("pipelineId"); //用于所有子请求的全局管道标识
        bulkRequest.routing("routingId"); //用于全局路由所有子请求
//        BulkRequest defaulted = new BulkRequest("posts"); //具有全局索引的批量请求，用于所有子请求，除非在子请求上被重写。此参数为@Nullable，只能在批量请求创建期间设置。

        BulkResponse bulkResponse = restHighLevelClient.bulk(bulkRequest, RequestOptions.DEFAULT);
    }




}
