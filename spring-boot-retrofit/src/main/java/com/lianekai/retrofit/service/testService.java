package com.lianekai.retrofit.service;

import com.lianekai.retrofit.api.HttpApi;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class testService {
    @Autowired
    private HttpApi httpApi;

    public void test(){
        //通过httpApi 发动http请求
    }
}
