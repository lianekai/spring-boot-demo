package com.lianekai.oauth2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/4/30 17:38
 */
@RestController
public class TestController {

    @GetMapping("hello")
    public String hello() {
        return "hello spring security";
    }
}
