package com.lianekai.sharding.pojo;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.*;

/**
 * @author lyk
 * @version: 1.0
 * @date 2020/11/13 10:32
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@TableName(value = "t_order")
public class Order {
    /** 主键 */
    @TableField(value = "id")
    private Long id;
    /** 用户id */
    @TableField(value = "user_id")
    private Long userId;
    /** 订单id */
    @TableField(value = "order_id")
    private Long orderId;
    /** 备注 */
    @TableField(value = "remark")
    private String remark;

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", orderId=" + orderId +
                ", remark='" + remark + '\'' +
                '}';
    }
}
