package com.lianekai.doc.pattern.single;

/**
 * 双检锁/双重校验锁（DCL，即 double-checked locking）
 *
 * @author yikai.lian
 * @version: 1.0
 * @date 2021/12/20 11:55
 */
public class Singleton4 {
    private volatile static Singleton4 singleton;
    private Singleton4 (){}
    public static Singleton4 getSingleton() {
        if (singleton == null) {
            synchronized (Singleton4.class) {
                if (singleton == null) {
                    singleton = new Singleton4();
                }
            }
        }
        return singleton;
    }

}
