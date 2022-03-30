package com.lianekai.sharding.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lianekai.sharding.pojo.Order;
import com.lianekai.sharding.pojo.OrderItem;
import org.apache.ibatis.annotations.Mapper;

/**
 * OrderItemMapper
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/03/30 11:31
 */
@Mapper
public interface OrderItemMapper extends BaseMapper<OrderItem> {
}
