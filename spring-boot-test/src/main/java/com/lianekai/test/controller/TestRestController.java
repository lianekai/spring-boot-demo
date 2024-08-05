package com.lianekai.test.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/5/9 8:53
 */
@RestController
public class TestRestController {

    @GetMapping("test7")
    public String test7(HttpServletResponse response) throws IOException {
        response.sendRedirect("http://www.baidu.com");
        return "test2";
    }

    @GetMapping("test8")
    public String test8(HttpServletResponse response) throws IOException {
        return "test888888";
    }

}
