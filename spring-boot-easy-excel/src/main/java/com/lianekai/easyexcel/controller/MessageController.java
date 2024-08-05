package com.lianekai.easyexcel.controller;

import com.lianekai.easyexcel.utils.MessageUtils;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * 测试消息转换
 *
 * @author lianyikai
 * @date 2024/4/10 20:04
 */
@RestController
@Log4j2
public class MessageController {

    @PostMapping("/message/test")
    public Boolean test(@RequestParam("messageKey") String messageKey){
        log.info(MessageUtils.get(messageKey));
        return Boolean.TRUE;
    }
}
