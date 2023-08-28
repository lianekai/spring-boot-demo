package com.lianekai.easyexcel.controller;

import com.lianekai.easyexcel.pojo.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2023/5/30 19:01
 **/
@Controller
@Log4j2
public class TestController {

    @PostMapping("/test")
    public Boolean saveUser(@RequestBody Object o){
        // 校验通过，才会执行业务逻辑处理
        log.info(o);
        return Boolean.TRUE;
    }
}
