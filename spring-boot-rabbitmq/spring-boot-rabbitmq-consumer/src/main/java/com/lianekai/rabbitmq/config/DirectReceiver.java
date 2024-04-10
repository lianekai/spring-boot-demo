package com.lianekai.rabbitmq.config;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * todo
 *
 * @author lianyikai
 * @date 2023/8/29 1:29
 */
@Component
public class DirectReceiver {

    @RabbitListener(queues = "simple.queue")
    public void handler1(String msg){
        System.out.println("handler1====="+msg);
    }
}
