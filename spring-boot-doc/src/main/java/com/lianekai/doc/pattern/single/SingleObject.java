package com.lianekai.doc.pattern.single;

import lombok.extern.slf4j.Slf4j;

/**
 * 单例对象
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 11:07
 */
@Slf4j
public class SingleObject {
    //创建 SingleObject 的一个对象
    private static SingleObject instance = new SingleObject();

    //让构造函数为 private，这样该类就不会被实例化
    private SingleObject(){}

    //获取唯一可用的对象
    static SingleObject getInstance(){
        return instance;
    }

    void showMessage(){
        log.info("我是一个单例对象~");
    }
}
