package com.lyk.zookeeper.util;

import org.apache.zookeeper.WatchedEvent;
import org.apache.zookeeper.Watcher;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.CountDownLatch;

/**
 * @author lyk
 * @version: 1.0
 * @date 19:50
 */
public class MyZkWatcher implements Watcher {

    private static final Logger log = LoggerFactory.getLogger(MyZkWatcher.class);

    //异步锁
    private CountDownLatch cdl;

    //标记
    private String mark;

    public MyZkWatcher(CountDownLatch cdl,String mark) {
        this.cdl = cdl;
        this.mark = mark;
    }

    //监听事件处理方法
    @Override
    public void process(WatchedEvent event) {
        log.info(mark+" watcher监听事件：{}",event);
        cdl.countDown();
    }

}