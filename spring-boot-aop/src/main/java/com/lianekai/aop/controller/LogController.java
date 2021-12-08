package com.lianekai.aop.controller;

import com.lianekai.aop.annotation.SysLog;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/06/15 21:00
 */
@RestController
public class LogController {

    @GetMapping("/testLogByAnnotation")
    public void testLogByAnnotation(){
        System.out.println("进来这个由注解控制器了哦，接下来调用具体的service吧");
    }

    @PostMapping("/testLogByBizAnnotation")
//    @SysLog
    public void testLogByBizAnnotation(){
        System.out.println("进来这个自定义控制器了哦，接下来调用具体的service吧");
    }


}
