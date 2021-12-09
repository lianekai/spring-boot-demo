package com.lianekai.redis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/08 12:03
 */
@RestController
public class TestController {
    @Autowired
    StringRedisTemplate stringRedisTemplate;

    @GetMapping("/helloRedis")
    public String hello(){
        stringRedisTemplate.opsForValue().set("name1","12456");
        System.out.println(stringRedisTemplate.opsForValue().get("name"));
        return "123456";
    }
}
