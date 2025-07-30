package com.lianekai.security.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * @author lianyikai
 * @date 2025年05月30日 00:48
 */
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //链式编程
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        //认证请求 功能只有对应权限的人才能访问
        //请求权想规则
        http.authorizeRequests()
                .antMatchers("/test/**").permitAll()//开启匹配规则，任何匹配的请求都允许访问
                .anyRequest().authenticated(); //除此之外的所有请求都需要授权

        //配置没有权限的时候，会跳转到登录页面
        http.formLogin();
    }
}
