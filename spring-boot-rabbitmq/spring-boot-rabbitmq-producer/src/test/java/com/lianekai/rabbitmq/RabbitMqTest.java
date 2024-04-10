package com.lianekai.rabbitmq;

import com.lianekai.rabbitmq.RabbitMqProducerApplication;
import org.junit.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * RabbitMqTest
 *
 * @author lianyikai
 * @date 2023/10/12 22:56
 */
@SpringBootTest(classes = RabbitMqProducerApplication.class)
public class RabbitMqTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Test
    public void testSent(){
        String queueName="simple.queue";
        String msg="hello amqp!";
        rabbitTemplate.convertAndSend(queueName,msg);
    }
}
