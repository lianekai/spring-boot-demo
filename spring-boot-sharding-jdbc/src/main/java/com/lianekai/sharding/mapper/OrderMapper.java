package com.lianekai.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianekai.sharding.pojo.Order;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * @author lyk
 * @version: 1.0
 * @date 10:38
 */
@Mapper
public interface OrderMapper extends BaseMapper<Order> {
}
