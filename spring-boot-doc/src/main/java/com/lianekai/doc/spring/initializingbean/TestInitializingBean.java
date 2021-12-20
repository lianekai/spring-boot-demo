package com.lianekai.doc.spring.initializingbean;

import cn.hutool.extra.spring.SpringUtil;
import com.lianekai.doc.spring.initializingbean.Bean1;
import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 14:43
 */
@Slf4j
public class TestInitializingBean{

    public static void main(String[] args) {
        log.info(SpringUtil.getBean(Bean1.class).toString());
        Bean1 bean1= SpringUtil.getBean(Bean1.class);
        log.info("bean的名字是："+bean1.getBeanName());
    }
}
