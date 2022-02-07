package com.lianekai.doc.pattern.single;

/**
 * 懒汉式，线程不安全
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 11:48
 */
public class Singleton1 {
    private static Singleton1 instance;
    private Singleton1(){}

    public static Singleton1 getInstance(){
        if(instance == null){
            instance =new Singleton1();
        }
        return instance;
    }
}
