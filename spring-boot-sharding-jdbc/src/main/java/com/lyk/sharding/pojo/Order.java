package com.lyk.sharding.pojo;

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
    private Long id;
    /** 用户id */
    private Long userId;
    /** 订单id */
    private Long orderId;
    /** 备注 */
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
