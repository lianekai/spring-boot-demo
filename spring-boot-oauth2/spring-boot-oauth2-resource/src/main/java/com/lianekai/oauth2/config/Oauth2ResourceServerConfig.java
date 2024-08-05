package com.lianekai.oauth2.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.RemoteTokenServices;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/4/25 10:25
 */
@Configuration
@EnableResourceServer //开启资源服务器
public class Oauth2ResourceServerConfig extends ResourceServerConfigurerAdapter {

    private static final String CHECK_TOKEN_URL = "http://localhost:8991/oauth/check_token";

    @Override
    public void configure(ResourceServerSecurityConfigurer resources) {

        RemoteTokenServices tokenService = new RemoteTokenServices();

        tokenService.setCheckTokenEndpointUrl(CHECK_TOKEN_URL);//授权服务器令牌校验地址
        tokenService.setClientId("admin"); //客户端信息
        tokenService.setClientSecret("{noop}123456");

        resources.tokenServices(tokenService);
    }

}
