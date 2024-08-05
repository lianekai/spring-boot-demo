package com.lianekai.oauth2.config;

import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;
import org.springframework.security.oauth2.provider.token.store.InMemoryTokenStore;

/**
 * todo
 *
 * @author lianyikai
 * @date 2024/4/25 9:33
 */
@Configuration
@EnableAuthorizationServer// 开启认证服务器
public class Oauth2ServerConfig extends AuthorizationServerConfigurerAdapter {

    @Autowired
    private AuthenticationManager authenticationManager;

    /**
     * 客户端配置
     *
     * @param clients
     * @throws Exception
     */
    @Override
    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
        clients.inMemory()
                .withClient("admin")
                .secret("{noop}123456")
                .autoApprove(false)
                .redirectUris("http://localhost:8991/login")
                .scopes("all")
                .accessTokenValiditySeconds(30*60)
                .authorizedGrantTypes("authorization_code", "refresh_token");
    }

    /**
     * 认证服务器的安全配置  端点权限
     *
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
        security//开启/oauth/check_token验证端口权限访问,checkTokenAccess()方法就是来确定是否有访问权限的
                .checkTokenAccess("permitAll()")
                .allowFormAuthenticationForClients();
    }

    /**
     * 令牌存储方式，内存
     * @param endpoints
     * @throws Exception
     */
    @Override
    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
      endpoints.authenticationManager(authenticationManager)
              .tokenStore(memoryTokenStore());
    }

    @Bean
    public TokenStore memoryTokenStore() {
        return new InMemoryTokenStore();
    }
}
