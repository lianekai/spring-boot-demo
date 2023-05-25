package com.lianekai.rocketmq.listener;

import com.lianekai.rocketmq.service.ProducerService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.client.producer.SendStatus;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

import java.io.UnsupportedEncodingException;
import java.util.List;

/**
 * @author lianyikai
 * @version 1.0
 * @description
 * @date 2022/11/11 15:08
 **/
@Slf4j
public class TestListenerConcurrently implements MessageListenerConcurrently {
    @Override
    public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
        String body = null;
        for (MessageExt messageExt : list) {

            try {
                body = new String(messageExt.getBody(), "utf-8");
//                jsonMsg = JSON.parseObject(body);
                log.info("consume收到消息：" + body);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
                //消息消费失败 重新放入队列
                reSendPushToMq(messageExt);
            } catch (Exception e ) {
                e.printStackTrace();
                reSendPushToMq(messageExt);
            }
        }
        //返回消费成功状态码  ，报错或者返回null broker 则会重新推消息，注意幂等性判断
        return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
    }
    /**
     * 重新发 推送消息 发送到队列中
     * @param message
     */
    public void reSendPushToMq(Message message) {
        try {
            SendResult result = ProducerService.getProducer().send(message);
            if (SendStatus.SEND_OK != result.getSendStatus()) {
                log.error("reSendPushToMq > " + result.toString());
            }
        } catch (Exception e) {
            log.error("reSendPushToMq Exception " + e.getMessage());
//            reSendPushToMq(message);
        }
    }

}
