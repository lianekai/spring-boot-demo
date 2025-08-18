package com.lianekai.redis.config;

import org.redisson.Redisson;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;
import org.redisson.config.SingleServerConfig;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/9/17 22:04
 **/
@Configuration
public class RedissonConfig {

    @Value(value = "${spring.redis.host}")
    private String host;
    @Value(value = "${spring.redis.port}")
    private String port;
    @Value(value = "${spring.redis.database}")
    private Integer database;

    @Value(value = "${spring.redis.password}")
    private String password;

    /**
     * 单Redis节点模式配置方法
     * 其他配置參數，看:
     * <a href = "https://github.com/redisson/redisson/wiki/2.-%E9%85%8D%E7%BD%AE%E6%96%B9%E6%B3%95#26-%E5%8D%95redis%E8%8A%82%E7%82%B9%E6%A8%A1%E5%BC%8F">
     * 单Redis节点模式配置方法
     * </a>
     *
     * @return {@link RedissonClient}
     */
    @Bean(destroyMethod = "shutdown")
    public RedissonClient getRedisson() {
        Config config = new Config();
        /**
         * Redis配置多节点
         * config.useClusterServers()
         *       .addNodeAddress("redis://127.0.0.1:6379", "redis://127.0.0.1:7001");
         * 这里配置单节点
         */
        SingleServerConfig singleServerConfig = config.useSingleServer();
        /**可以用"redis://"来启用SSL连接*/
        String address = "redis://" + host + ":" + port;
        singleServerConfig.setAddress(address);
        /**设置 数据库编号*/
        singleServerConfig.setDatabase(database);
        singleServerConfig.setPassword(password);
        /**连接池大小:默认值：64*/
        // singleServerConfig.setConnectionPoolSize()
        return Redisson.create(config);
    }
}
