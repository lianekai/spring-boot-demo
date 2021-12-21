package com.lianekai.redis.service.impl;

import com.lianekai.redis.service.OrderService;

/**
 * OrderService实现类
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/21 15:35
 */
public class OrderServiceImpl implements OrderService {

    @Override
    public void produceOrderNo() {
        /**产生5个订单号放入redis zset*/
        for(int i=0;i<5;i++){

        }
    }

    @Override
    public void consumerOrder() {

    }
}
