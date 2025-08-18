package com.lianekai.rocketmq;

import com.lianekai.rocketmq.util.SpringContextUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 14:48
 **/
@SpringBootApplication
public class RocketMqApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext context =SpringApplication.run(RocketMqApplication.class,args);
        SpringContextUtils.setApplicationContext(context);
    }
}
