package com.lianekai.heartbeat.entity;



import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 心跳包实体类
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2020/12/24 14:12
 */
@Setter
@Getter
public class HeartbeatEntity implements Serializable {
    private long time;
    private String nodeID;
    private String error;
    private Map<String, Object> info = new HashMap<String, Object>();
}
