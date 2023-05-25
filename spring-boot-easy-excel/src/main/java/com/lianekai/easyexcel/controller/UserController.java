package com.lianekai.easyexcel.controller;

import com.lianekai.easyexcel.pojo.dto.UserDTO;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 用户控制器
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/11/24 00:03
 */
@Controller
@Log4j2
public class UserController {

    @PostMapping("/saveUser")
    public Boolean saveUser(@RequestBody  @Validated UserDTO userDTO){
        // 校验通过，才会执行业务逻辑处理
        log.info(userDTO.toString());
        return Boolean.TRUE;
    }
}
