package com.lianekai.doc.pattern.single;

/**
 * 懒汉式，线程安全
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 11:50
 */
public class Singleton2 {
    private static Singleton2 instance;
    public static synchronized Singleton2 getInstance(){
        if (instance == null) {
            instance = new Singleton2();
        }
        return instance;
    }
}
