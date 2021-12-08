package com.lianekai.heartbeat.hander;

import com.lianekai.heartbeat.entity.Cmder;
import com.lianekai.heartbeat.entity.HeartbeatEntity;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/24 14:23
 */
public interface HeartbeatHandler {
    public Cmder sendHeartBeat(HeartbeatEntity info);
}
