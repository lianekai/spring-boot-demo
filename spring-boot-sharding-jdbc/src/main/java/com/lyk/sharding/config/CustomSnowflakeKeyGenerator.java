package com.lyk.sharding.config;

import cn.hutool.core.lang.Snowflake;
import io.shardingsphere.core.keygen.KeyGenerator;

/**
 * @author lyk
 * @version: 1.0
 * @date 11:26
 */
public class CustomSnowflakeKeyGenerator implements KeyGenerator {

    private Snowflake snowflake;

    public CustomSnowflakeKeyGenerator(Snowflake snowflake) {
        this.snowflake = snowflake;
    }

    @Override
    public Number generateKey() {
        return snowflake.nextId();
    }
}
