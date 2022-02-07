package com.lianekai.easyexcel.common;

import lombok.Getter;
import lombok.Setter;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 18:11
 */
@Getter
@Setter
public class Response<T> {
    private Integer code;
    private String message;
    private T data;
}
