package com.lianekai.oauth2.controller;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/4/25 10:31
 */
@RestController
@RequestMapping("/cms")
public class HelloController {
    @GetMapping("/getCurrentUser")
    public Object getCurrentUser(Authentication authentication) {
        return authentication;
    }

    @GetMapping("/index")
    public String index() {
        return "index";
    }


    @PutMapping("/index2")
    public String index2() {
        return "index2";
    }

}
