package com.lianekai.caffeine.config;

import com.github.benmanes.caffeine.cache.CacheLoader;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Cache配置类
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/01/23 20:02
 */
@Configuration
public class CacheConfig {
    /**
     * 相当于构建LoadingCache对象的时候build（）方法指定过期之后的加载策略方法
     * 必须指定这个bean，refreshAfterWrite=60s属性才能生效
     */
    @Bean
    public CacheLoader<String,Object> cacheLoader(){
        CacheLoader<String,Object> cacheLoader=new CacheLoader<String,Object>(){
            @Override
            public Object load(String key) throws Exception{
                return null;
            }
            @Override
            public Object reload(String key,Object oldValue)throws Exception{
                return oldValue;
            }

        };
        return cacheLoader;
    }

}
