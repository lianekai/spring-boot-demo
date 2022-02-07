package com.lianekai.doc.pattern.single;

/**
 * 饿汉式
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 11:52
 */
public class Singleton3 {
    private volatile static Singleton3 instance= new Singleton3();
    private Singleton3(){}

    public static Singleton3 getInstance() {
        return instance;
    }
}
