package com.lyk.swagger.pojo;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * @author lyk
 * @version: 1.0
 * @date 14:06
 */
@Getter
@Setter
public class User implements Serializable {
    private String username;
    private String password;


    public User(String username, String java) {
        this.username=username;
        this.password=java;
    }
}
