package com.lainekai.thread.service;

/**
 * Runnable 测试类
 * Runnable 是一个函数式接口，可以用函数式编程简化代码
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/09 22:18
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        System.out.println("这是一个runnable 测试程序！！"+"当前正在执行的线程是:"+Thread.currentThread().getName());
    }
}
