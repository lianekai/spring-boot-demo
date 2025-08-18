package com.lianekai.rocketmq.service;

import com.lianekai.rocketmq.config.RocketMqConfig;
import com.lianekai.rocketmq.listener.TestListenerConcurrently;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.consumer.ConsumeFromWhere;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Service;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 14:51
 **/
@Service
public class ConsumerService implements InitializingBean {

    /**
     * 消费者组
     */
    public static final String CONSUMER_GROUP = "consumer_test_group";

    /**
     * 消费者实体对象
     */

    private DefaultMQPushConsumer consumer;

    /**
     *构造函数 实例化对象
     */

    public DefaultMQPushConsumer getPushConsumer () {
        if (null != consumer) {
            return consumer;
        }
        consumer = new DefaultMQPushConsumer(CONSUMER_GROUP);
        consumer.setNamesrvAddr(RocketMqConfig.NAME_SERVER);
        //消费模式:一个新的订阅组第一次启动从队列的最后位置开始消费
        // 后续再启动接着上次消费的进度开始消费
        consumer.setConsumeFromWhere(ConsumeFromWhere.CONSUME_FROM_LAST_OFFSET);
        /**
         * 监听拉取消息
         */
        consumer.registerMessageListener(new TestListenerConcurrently());
        try {
            consumer.subscribe(RocketMqConfig.TOPIC, "*");
            consumer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
        return consumer;
    }


    @Override
    public void afterPropertiesSet() throws Exception {
        DefaultMQPushConsumer consumer = getPushConsumer();
    }
}
