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
@Controller
public class Test1Controller {

    @GetMapping("test1")
    public String test1(){
        //重定向回后端接口
        return "test8";
    }


    @GetMapping("test2")
    public String test2(HttpServletResponse response) throws IOException {
        response.sendRedirect("/test1");
        return "test2";
    }


    @GetMapping("test3")
    public String test3(){
        return "test1111111111111";
    }


    @GetMapping("test4")
    public String test4(){
        return "redirect:/test1";
    }


    @GetMapping("test5")
    public String test5(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://www.baidu.com");
        return "test2";
    }


    @GetMapping("test6")
    public String test6(){
        //重定向回后端接口
        return "test8";
    }

    @GetMapping("test9")
    public  RedirectView test9(){
        //也可以重定向到百度页面
        return new RedirectView("http://www.baidu.com");
    }

    @GetMapping("test10")
    public  String test10(){
        //也可以重定向到百度页面
        return "redirect:http://www.baidu.com";
    }
}
