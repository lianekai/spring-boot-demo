package com.lianekai.es.controller;

import com.lianekai.es.util.ElasticSearchUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * ElasticSearchController
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/14 11:12
 */
@RestController
public class ElasticSearchController {

    @PostMapping(value = "es/createIndex")
    public Boolean createIndex(@RequestParam("indexName") String indexName) throws IOException {
        return ElasticSearchUtils.creatIndex(indexName);
    }

    @PostMapping(value = "es/addDoc")
    public Boolean addDoc(@RequestParam("indexName") String indexName) throws IOException {
        return ElasticSearchUtils.addDoc(indexName);
    }

    @PostMapping(value = "es/getDoc")
    public void getDoc(@RequestParam("index") String index,@RequestParam("id") String id) throws IOException {
        ElasticSearchUtils.getDoc(index,id);
    }

    @PostMapping(value = "es/bulk")
    public void bulk() throws IOException {
        ElasticSearchUtils.bulkRequest();
    }
}
