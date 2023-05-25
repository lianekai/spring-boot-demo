package com.lianekai.rocketmq.service;

import com.lianekai.rocketmq.config.RocketMqConfig;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.springframework.stereotype.Service;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 14:50
 **/
@Service
public class ProducerService {

    /**消息生产者群组*/
    private static  final String producerGroup = "producer_test_group";

    private static DefaultMQProducer producer;

    public static DefaultMQProducer getProducer() {
        if (producer == null) {
            /**
             * 生产者group名
             */
            producer = new DefaultMQProducer(producerGroup);
            producer.setVipChannelEnabled(false);
            /**
             * Name Server 地址，因为是集群部署 所以有多个用 分号 隔开
             */
            producer.setNamesrvAddr(RocketMqConfig.NAME_SERVER);
            /**
             * 主题名称 主题一般是服务器设置好 而不能在代码里去新建topic（ 如果没有创建好，生产者往该主题发送消息 会报找不到topic错误）
             */
            producer.setCreateTopicKey(RocketMqConfig.TOPIC);

            try {
                producer.start();
            } catch (MQClientException e) {
                e.printStackTrace();
            }
        }
        return producer;
    }


    /**
     * 一般在应用上下文，使用上下文监听器，进行关闭
     */
    public void shutdown(){
        producer.shutdown();
    }



}
