package com.lianekai.test;

import com.lianekai.test.utils.MailUtil;
import javax.mail.MessagingException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 测试服务
 *
 * @author lianyikai
 * @date 2024/5/9 8:41
 */
@SpringBootApplication
public class TestApplication {
    public static void main(String[] args) throws MessagingException {
        SpringApplication.run(TestApplication.class,args);
    }
}