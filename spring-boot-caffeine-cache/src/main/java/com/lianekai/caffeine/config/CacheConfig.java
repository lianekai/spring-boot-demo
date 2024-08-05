package com.lianekai.caffeine.config;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.CacheLoader;
import com.github.benmanes.caffeine.cache.Caffeine;
import com.google.common.collect.Lists;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCache;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

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
        return new CacheLoader<String,Object>(){
            @Override
            public Object load(String key) throws Exception{
                return null;
            }
            @Override
            public Object reload(String key,Object oldValue)throws Exception{
                return oldValue;
            }

        };
    }

    /**
     * 创建基于Caffeine的Cache Manager
     *
     * @return
     */
    @Bean
    @Primary
    public CacheManager caffeineCacheManager() {
        SimpleCacheManager cacheManager = new SimpleCacheManager();
        ArrayList<CaffeineCache> caches = Lists.newArrayList();
        Map<String, Object> map = getCacheType();
        for (String name : map.keySet()) {
            caches.add(new CaffeineCache(name, (Cache<Object, Object>) map.get(name)));
        }
        cacheManager.setCaches(caches);
        return cacheManager;
    }

    /**
     * 初始化自定义缓存策略
     *
     * @return Map
     */
    private static Map<String, Object> getCacheType() {
        Map<String, Object> map = new ConcurrentHashMap<>();
        map.put("name1", Caffeine.newBuilder().recordStats()
                .expireAfterWrite(10, TimeUnit.SECONDS)
                .maximumSize(100)
                .build());
        map.put("name2", Caffeine.newBuilder().recordStats()
                .expireAfterWrite(50, TimeUnit.SECONDS)
                .maximumSize(50)
                .build());
        return map;
    }

}
