package com.lianekai.test.service.event;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Component;

/**
 * 事件监听器
 *
 * @author lianyikai
 * @date 2025/2/17 23:36
 */
@Component
@Slf4j
public class TestEventListener implements ApplicationListener<TestEvent> {
    @Override
    public void onApplicationEvent(@NonNull TestEvent testEvent) {
        String source = (String)testEvent.getSource();
        log.info("监听到事件：{},{}", testEvent,source);
    }
}
