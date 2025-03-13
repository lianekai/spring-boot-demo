package com.lianekai.test.controller;

import com.lianekai.test.service.event.TestEventPublisher;
import java.io.IOException;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * event
 *
 * @author lianyikai
 * @date 2025/2/17 23:47
 */
@RestController
public class TestEventController {
    @Resource
    private TestEventPublisher eventPublisher;

    @GetMapping("/test-event")
    public void test1(HttpServletResponse response) throws IOException {
        eventPublisher.publishEvent("testEvent");
    }
}
