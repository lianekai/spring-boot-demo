package com.lianekai.doc.pattern.single;

import lombok.extern.slf4j.Slf4j;

/**
 * TODO
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 11:12
 */
@Slf4j
public class TestSingle {
    public static void main(String[] args) {
        SingleObject singleObject=SingleObject.getInstance();
        singleObject.showMessage();
        log.info("调用完单例对象了");
    }

}
