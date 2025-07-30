package com.lianekai.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author lianyikai
 * @date 2025年05月30日 00:41
 */
@Controller
@ResponseBody
public class TestController {

    @GetMapping("/test1")
    public String test1(){
        return "test1";
    }

    @GetMapping("/test2")
    public String test2(){
        return "test2";
    }

    @GetMapping("/hhh")
    public String hhh(){
        return "hhh1";
    }
}
