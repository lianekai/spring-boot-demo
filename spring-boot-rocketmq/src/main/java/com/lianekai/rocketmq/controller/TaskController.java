package com.lianekai.rocketmq.controller;

import com.lianekai.rocketmq.config.RocketMqConfig;
import com.lianekai.rocketmq.service.ProducerService;
import com.lianekai.rocketmq.util.ExecutorUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ExecutorService;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 15:12
 **/
@RestController
@Slf4j
public class TaskController {

    @Scheduled(cron = "0/10 * * * * ?") // 每10s执行一次
    public void task() throws Exception {
        LocalDateTime localDateTime = LocalDateTime.now();
        Thread.currentThread().setName(UUID.randomUUID().toString());
        String msg=new StringBuffer().append(localDateTime + ":" + Thread.currentThread().getName()).toString();
        org.apache.rocketmq.common.message.Message message= new org.apache.rocketmq.common.message.Message(RocketMqConfig.TOPIC,msg.getBytes("utf-8"));


        java.util.Random random= new  java.util.Random(); // 定义随机类
        int  radnow=random.nextInt( 10 );
        log.info("radnow : " + radnow );
//        ExecutorService threadPool = ExecutorUtils.getExecutor();
        for (int i = 0; i <radnow; i++) {
            SendResult result = ProducerService.getProducer().send(message);
            //返回状态码 ok则发送成功
            if(SendStatus.SEND_OK!=result.getSendStatus()){
                log.error(result.toString() );
            } else {
                log.info(Thread.currentThread().getName() + " : 发送成功");
            }
        }

    }
}
