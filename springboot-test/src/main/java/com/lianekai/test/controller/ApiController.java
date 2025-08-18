package com.lianekai.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/5/9 8:44
 */
@Controller("Api")
public class ApiController {

    @GetMapping("test11")
    public String test1(){
        //重定向回后端接口
        return "test8";
    }
}
