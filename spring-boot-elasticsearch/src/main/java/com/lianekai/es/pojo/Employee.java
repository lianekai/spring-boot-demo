package com.lianekai.es.pojo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;
import org.springframework.data.elasticsearch.annotations.Document;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/18 23:36
 */
@Getter
@Setter
@ToString
@Accessors(chain = true)
@Document(indexName = "company",type = "employee", shards = 1,replicas = 0, refreshInterval = "-1")
public class Employee {
    private String id;
    private String firstName;
    private String lastName;
    private Integer age = 0;
    private String about;

    public static Employee of(){
        return new Employee();
    }
}
