package com.lianekai.aop.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lianekai.aop.annotation.PermissionAnno;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/06/15 22:43
 */
@RestController
public class PermissionController {
    @PostMapping(value = "/check")
    // 添加这个注解
    @PermissionAnno
    public JSONObject getGroupList(@RequestBody JSONObject request) {
        return JSON.parseObject("{\"message\":\"SUCCESS\",\"code\":200}");
    }

}
