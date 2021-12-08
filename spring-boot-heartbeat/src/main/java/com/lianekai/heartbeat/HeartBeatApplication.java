package com.lianekai.heartbeat;


import com.lianekai.heartbeat.client.HeartBeatClient;
import com.lianekai.heartbeat.hander.HeartbeatHandler;
import com.lianekai.heartbeat.hander.impl.HeartbeatHandlerImpl;
import com.lianekai.heartbeat.server.ServiceCenter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

/**
 * 心跳机制测试启动类
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/24 14:00
 */
@SpringBootApplication
public class HeartBeatApplication {
    public static void main(String[] args) {
        SpringApplication.run(HeartBeatApplication.class,args);
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    ServiceCenter serviceServer = ServiceCenter.getInstance();
                    serviceServer.register(HeartbeatHandler.class, HeartbeatHandlerImpl.class);
                    serviceServer.start();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
        Thread client1 = new Thread(new HeartBeatClient());
        client1.start();
        Thread client2 = new Thread(new HeartBeatClient());
        client2.start();

        //测试已提交

    }
}

