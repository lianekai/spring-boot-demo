## 项目主要为java多线程巩固基础
#### 线程的生命周期
![thread1](thread1.png "thread1")
#### 线程的优先级
每一个 Java 线程都有一个优先级，这样有助于操作系统确定线程的调度顺序。
Java 线程的优先级是一个整数，其取值范围是 1 （Thread.MIN_PRIORITY ） - 10 （Thread.MAX_PRIORITY ）。
默认情况下，每一个线程都会分配一个优先级 NORM_PRIORITY（5）。
具有较高优先级的线程对程序更重要，并且应该在低优先级的线程之前分配处理器资源。但是，线程优先级不能保证线程执行的顺序，而且非常依赖于平台。
#### 创建新线程
Java语言内置了多线程支持。当Java程序启动的时候，实际上是启动了一个JVM进程，然后，JVM启动主线程来执行main()方法。在main()方法中，我们又可以启动其他线程。
要创建一个新线程非常容易，我们需要实例化一个Thread实例，然后调用它的start()方法

#### Java 提供了四种创建线程的方法：
通过继承 Thread 类本身；
通过实现 Runnable 接口；
通过 Callable 和 Future 创建线程；
通过线程池创建线程。



#### 线程池