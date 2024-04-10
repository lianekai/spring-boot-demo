package com.lianekai.rabbitmq;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * RabbitMQ 生产者服务
 *
 * @author lianyikai
 * @date 2023/8/26 16:45
 */
@SpringBootApplication
@EnableRabbit
public class RabbitMqProducerApplication {
    public static void main(String[] args) {
        SpringApplication.run(RabbitMqProducerApplication.class,args);
    }
}