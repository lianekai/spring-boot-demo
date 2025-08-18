package com.lianekai.test.service.event;

import lombok.Getter;
import lombok.Setter;
import org.springframework.context.ApplicationEvent;

/**
 * event
 *
 * @author lianyikai
 * @date 2025/2/17 23:34
 */
@Getter
@Setter
public class TestEvent extends ApplicationEvent {

    private String msg;

    public TestEvent(Object source, String msg) {
        super(source);
        this.msg = msg;
    }
}
