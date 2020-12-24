package com.lianekai.heartbeat.hander.impl;

import com.lianekai.heartbeat.entity.Cmder;
import com.lianekai.heartbeat.entity.HeartbeatEntity;
import com.lianekai.heartbeat.hander.HeartbeatHandler;
import com.lianekai.heartbeat.listener.HeartbeatListener;

import java.util.Map;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/24 14:24
 */
public class HeartbeatHandlerImpl implements HeartbeatHandler {
    @Override
    public Cmder sendHeartBeat(HeartbeatEntity info) {
        HeartbeatListener linstener = HeartbeatListener.getInstance();

        // 添加节点
        if (!linstener.checkNodeValid(info.getNodeID())) {
            linstener.registerNode(info.getNodeID(), info);
        }

        // 其他操作
        Cmder cmder = new Cmder();
        cmder.setNodeID(info.getNodeID());
        // ...

        System.out.println("current all the nodes: ");
        Map<String, Object> nodes = linstener.getNodes();
        for (Map.Entry e : nodes.entrySet()) {
            System.out.println(e.getKey() + " : " + e.getValue());
        }
        System.out.println("hadle a heartbeat");
        return cmder;
    }
}

