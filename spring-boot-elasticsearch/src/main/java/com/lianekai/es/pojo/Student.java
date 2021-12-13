package com.lianekai.es.pojo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


import java.io.Serializable;

/**
 * Student
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/05/05 15:52
 */
@Getter
@Setter
@ToString
@JsonIgnoreProperties({"handler","hibernateLazyInitializer"})
public class Student implements Serializable {
    private static final long serialVersionUID = 551589397625941750L;



    private Long id;

    private String name;


}
