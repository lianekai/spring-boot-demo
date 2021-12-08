package com.lianekai.es.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/05 15:52
 */
@Document(indexName = "student_index", type = "student", shards = 5,
        replicas = 1, indexStoreType = "fs", refreshInterval = "-1")
public class Student implements Serializable {
    private static final long serialVersionUID = 551589397625941750L;

    @Id
    // @Field(index = FieldIndex.not_analyzed, store = true, type = FieldType.Long)
    private Long id;


}
