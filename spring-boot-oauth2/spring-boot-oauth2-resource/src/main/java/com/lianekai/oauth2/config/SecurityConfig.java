package com.lianekai.oauth2.config;

import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/4/25 10:29
 */
@EnableWebSecurity //1.开启spring security
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/**").authenticated();  //2.所有资源认证后访问
        // 禁用CSRF
        http.csrf().disable(); //3.关闭跨域保护
    }

}
