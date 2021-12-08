package com.lianekai.zookeeper.controller;

import com.lianekai.zookeeper.util.MyZkConnect;
import org.apache.zookeeper.KeeperException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;

/**
 * @author lyk
 * @version: 1.0
 * @date 20:07
 */
@RestController
@RequestMapping("/zk")
public class ZkController {


    @GetMapping("/connect")
    public String getFormZk() throws IOException, InterruptedException, KeeperException {

        MyZkConnect.queryStat(MyZkConnect.connect(),"/name");

        String name=MyZkConnect.queryData(MyZkConnect.connect(),"/name");

        return name;
    }
}
