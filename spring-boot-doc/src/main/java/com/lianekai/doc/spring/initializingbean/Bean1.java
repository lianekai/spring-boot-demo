package com.lianekai.doc.spring.initializingbean;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.InitializingBean;

/**
 * bean1
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 14:44
 */
@Slf4j
@Getter
public class Bean1 implements InitializingBean {
    private String beanName;
    @Override
    public void afterPropertiesSet() throws Exception {
        log.info("正在进行bean的初始化");
        beanName="lianyikai";
    }
}
