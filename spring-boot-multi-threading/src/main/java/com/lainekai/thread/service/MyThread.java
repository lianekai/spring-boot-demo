package com.lainekai.thread.service;

/**
 * 继承Thread实现多线程
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/08 22:52
 */
public class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("我的线程开始启动了~");
    }
}
