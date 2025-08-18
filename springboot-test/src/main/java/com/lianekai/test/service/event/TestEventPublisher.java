package com.lianekai.test.service.event;

import javax.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * TestEventPublisher
 *
 * @author lianyikai
 * @date 2025/2/17 23:41
 */
@Component
@Slf4j
public class TestEventPublisher  {

    @Resource
    private ApplicationEventPublisher eventPublisher;

    public void publishEvent(String msg) {
        log.info("publishEvent:{}",msg);
        eventPublisher.publishEvent(new TestEvent(msg,msg));
    }

}
