package com.lianekai.doc.pattern.single;

/**
 * 登记式/静态内部类
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 14:01
 */
public class Singleton5 {
    private static class SingletonHolder {
        private static final Singleton5 INSTANCE = new Singleton5();
    }
    private Singleton5 (){}
    public static final Singleton5 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
