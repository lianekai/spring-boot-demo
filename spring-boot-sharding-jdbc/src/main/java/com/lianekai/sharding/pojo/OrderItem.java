package com.lianekai.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * OrderItem
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/03/30 11:05
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "t_order_item")
public class OrderItem {
    /** 主键 */
    @TableField(value = "id")
    private Long id;

    /** 订单id */
    @TableField(value = "order_id")
    private Long orderId;

    /** 订单名称 */
    @TableField(value = "order_name")
    private String orderName;

    /** 订单描述 */
    @TableField(value = "order_desc")
    private String orderDesc;

}
