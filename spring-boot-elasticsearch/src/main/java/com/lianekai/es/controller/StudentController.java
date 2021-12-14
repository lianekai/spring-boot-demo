package com.lianekai.es.controller;

import com.alibaba.fastjson.JSONObject;
import com.lianekai.es.config.ElasticSearchConfig;
import com.lianekai.es.pojo.Student;

import lombok.extern.slf4j.Slf4j;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentController
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/13 10:50
 */
@RestController
@Slf4j
public class StudentController {
    @Autowired
    private RestHighLevelClient restHighLevelClient;

    @PostMapping("/findStudent")
    public List<Student> findStudentById(@RequestParam("type")String type,@RequestParam("text")String text) throws IOException {
        SearchRequest searchRequest = new SearchRequest();
        SearchSourceBuilder searchSourceBuilder = new SearchSourceBuilder();
        BoolQueryBuilder boolQuery = QueryBuilders.boolQuery();
        // 在must下添加match条件完成模糊匹配
        boolQuery.must(QueryBuilders.matchQuery(type, text));
        // 将条件添加入检索条件
        searchSourceBuilder.query(boolQuery);
        searchRequest.source(searchSourceBuilder);

        SearchResponse searchResponse=restHighLevelClient.search(searchRequest, ElasticSearchConfig.COMMON_OPTIONS);
        List<Student> students=new ArrayList<>();
        if (searchResponse.status().getStatus() == HttpStatus.OK.value()) {
            SearchHit[] hits = searchResponse.getHits().getHits();
            for (int i = 0; i < hits.length; i++) {
                SearchHit hit=hits[i];
                String json=hit.getSourceAsString();
                log.info(json);
                JSONObject jsonObject=JSONObject.parseObject(json);
                Student student=JSONObject.toJavaObject(jsonObject,Student.class);
                student.setId(Long.parseLong(hit.getId()));
                students.add(student);
//                Object json =hit.getSourceAsMap().get("json");
            }
        }
        return students;
    }




    @PostMapping("/saveStudent")
    public Boolean saveStudent(){
        return true;
    }

}
