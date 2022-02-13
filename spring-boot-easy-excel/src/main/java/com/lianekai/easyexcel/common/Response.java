package com.lianekai.easyexcel.common;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/04 18:11
 */
@Getter
@Setter
@Accessors(chain = true)
public class Response<T> {
    private Integer code;
    private String message;
    private T data;

    public static <T> Response<T> returnSuccess(T data){
        Response<T> response=new Response<>();
        response.setCode(200);
        response.setData(data);
        return response;
    }
}
