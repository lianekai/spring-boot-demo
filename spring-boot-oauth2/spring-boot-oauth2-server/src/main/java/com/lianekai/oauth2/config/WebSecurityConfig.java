package com.lianekai.oauth2.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/4/25 9:44
 */
@Configuration
@EnableWebSecurity  //1.开启spring security的功能
@Order(1)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    /**
     * 设置用户信息，内存存储,自定义认证用户的信息
     * @param auth
     * @throws Exception
     */
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123456")
                .roles("admin");
    }

    /**
     * 放行静态资源
     * @param web
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity web) throws Exception {
        //解决静态资源被拦截问题
        //web.ignoring().antMatchers("/asserts/**");
    }

    /**
     * 授权资源全局配置
     * @param http
     * @throws Exception
     */
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.formLogin()
                .permitAll()
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .and()
                .authorizeRequests()// 授权配置
                .antMatchers("/oauth/**","/login/**","/logout/**","/api/**").permitAll()
                .anyRequest()
                .authenticated()
                .and().csrf().disable();
    }

    @Override
    @Bean
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }
}
