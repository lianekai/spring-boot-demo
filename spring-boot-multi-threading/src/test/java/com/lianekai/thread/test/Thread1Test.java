package com.lianekai.thread.test;

import com.lainekai.thread.service.MyThread;

/**
 * Thread1Test
 *
 * @author lianekai
 * @version: 1.0
 * @date 2021/12/14 23:33
 */
public class Thread1Test{
    public static void main(String[] args) {
        MyThread thread1=new MyThread();
        thread1.start();//调用start()方法后，该线程才算启动！

        /**我们在程序里面调用了start()方法后，虚拟机会先为我们创建一个线程，然后等到这个线程第一次得到时间片时再调用run()方法。
         注意不可多次调用start()方法。在第一次调用start()方法后，再次调用start()方法会抛出IllegalThreadStateException异常。*/
    }
}
