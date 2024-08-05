package com.lianekai.stream.pojo;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author lyk
 * @version: 1.0
 * @date 10:37
 */
@Data
public class Person {
    private String name;
    private Integer salary;
    private Integer age;
    private String sex;
    private String area;

    public Person(String name, Integer salary, Integer age, String sex, String area) {
        this.name = name;
        this.salary = salary;
        this.age = age;
        this.sex = sex;
        this.area = area;
    }



}
