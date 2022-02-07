package com.lianekai.doc.spring.delayed;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 17:04
 */
public class OrderDelay implements Delayed {
    private String orderId;
    private long timeout;

    OrderDelay(String orderId, long timeout){
        this.orderId=orderId;
        this.timeout=timeout+System.nanoTime();
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(timeout - System.nanoTime(), TimeUnit.NANOSECONDS);
    }

    @Override
    public int compareTo(Delayed other) {
        if (other == this) {
            return 0;
        }

        OrderDelay t = (OrderDelay) other;

        long d = (getDelay(TimeUnit.NANOSECONDS) -
                t.getDelay(TimeUnit.NANOSECONDS));
        return (d == 0) ? 0 : ((d < 0) ? (-1) : 1);
    }

    void print() {
        System.out.println(orderId + "编号的订单要删除啦。。。。");
    }
}
