package com.lianekai.thread.test;

import com.lainekai.thread.service.MyRunnable;

/**
 * TODO
 *
 * @author lianekai
 * @version: 1.0
 * @date 2022/02/09 22:24
 */
public class RunnableTest {
    public static void main(String[] args) {
        new Thread(new MyRunnable(),"线程1").start();//将runnable 对象传递给Thread对象去启动

        //还有一种函数式编程方式
        new Thread(()->{
            System.out.println("这是用函数编程方式启动的:"+Thread.currentThread().getName());
        },"线程2").start();//同样一个线程创建后要启动才会实际有作用


    }
}
