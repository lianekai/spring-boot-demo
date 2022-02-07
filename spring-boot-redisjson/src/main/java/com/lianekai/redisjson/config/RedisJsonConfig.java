package com.lianekai.redisjson.config;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import redis.clients.jedis.*;

/**
 * 连接redis配置
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/01/04 22:52
 */
@Configuration
public class RedisJsonConfig {

    @Bean
    public Jedis connect2Redis(){
        JedisPool jedisPool=new JedisPool("192.168.147.130", 6379);
        Jedis jedis
                =jedisPool.getResource();
        return jedis;
    }
}
