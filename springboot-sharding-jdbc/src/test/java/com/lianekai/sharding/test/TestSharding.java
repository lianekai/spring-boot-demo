package com.lianekai.sharding.test;

import cn.hutool.core.util.RandomUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.lianekai.sharding.mapper.OrderMapper;
import com.lianekai.sharding.pojo.Order;
import lombok.extern.slf4j.Slf4j;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * @author lyk
 * @version: 1.0
 * @date 11:34
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class TestSharding {
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 测试新增
     */
    @Test
    public void testInsert() {
        for (long i = 1; i < 10; i++) {
            for (long j = 1; j < 20; j++) {
                Order order = Order.builder().userId(i).orderId(j).remark(RandomUtil.randomString(20)).build();
                orderMapper.insert(order);
            }
        }
    }

    /**
     * 测试更新
     */
    @Test
    public void testUpdate() {
        Order update = new Order();
        update.setRemark("修改备注信息");
        orderMapper.update(update, Wrappers.<Order>update().lambda().eq(Order::getOrderId, 2).eq(Order::getUserId, 2));
    }

    /**
     * 测试删除
     */
    @Test
    public void testDelete() {
        orderMapper.delete(new QueryWrapper<>());
    }

    /**
     * 测试查询
     */
    @Test
    public void testSelect() {
        List<Order> orders = orderMapper.selectList(Wrappers.<Order>query().lambda().in(Order::getOrderId, 1, 2));
        System.out.println(orders.get(1).toString());
    }


}
