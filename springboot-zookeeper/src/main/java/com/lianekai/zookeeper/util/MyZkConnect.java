package com.lianekai.zookeeper.util;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.apache.zookeeper.*;
import org.apache.zookeeper.data.ACL;
import org.apache.zookeeper.data.Stat;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;


/**
 * @author lyk
 * @version: 1.0
 * @date 20:36
 * @Decription: Zk连接工具类
 */

public class MyZkConnect {
    private static Logger logger = LogManager.getLogger(MyZkConnect.class);
    /**
     * 单一节点连接
     */
    public static final String zkServerSingConnect = "192.168.111.129:2181";

    public static final int timeout = 3000;


    public static ZooKeeper connect() throws IOException,InterruptedException{
        CountDownLatch cdl=new CountDownLatch(1);
        logger.info("准备连接zk");
        Watcher watcher;
        ZooKeeper zk=new ZooKeeper(zkServerSingConnect, timeout, new MyZkWatcher(cdl,"重新连接"));
        logger.info("完成建立zk服务");
        cdl.await();//这里为了等待wather监听事件结束
        return zk;
    }


    /**
     * 描述：重新连接服务
     * 作者：七脉
     * @param sessionId 现有会话ID
     * @param sessionPasswd 现有会话密码
     * @return
     * @throws IOException
     * @throws InterruptedException
     * 重点：关闭后的会话连接，不支持重连。重连后，前会话连接将会失效。
     */
    public static ZooKeeper reconnect(long sessionId, byte[] sessionPasswd) throws IOException, InterruptedException{
        CountDownLatch cdl = new CountDownLatch(1);
        logger.info("准备重新连接zk服务");
        ZooKeeper zk = new ZooKeeper(zkServerSingConnect, timeout, new MyZkWatcher(cdl,"重新连接"), sessionId, sessionPasswd);
        logger.info("完成重新连接zk服务");
        cdl.await();//这里为了等待wather监听事件结束
        return zk;
    }


    /**
     * 描述：创建节点
     * 作者：七脉
     * @param zk
     * @param nodePath
     * @param nodeData
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static void create(ZooKeeper zk,String nodePath,String nodeData) throws KeeperException, InterruptedException{
        //logger.info("开始创建节点：{}， 数据：{}",nodePath,nodeData);
        List<ACL> acl = ZooDefs.Ids.OPEN_ACL_UNSAFE;
        CreateMode createMode = CreateMode.PERSISTENT;
        String result = zk.create(nodePath, nodeData.getBytes(), acl, createMode);
        //创建节点有两种，上面是第一种，还有一种可以使用回调函数及参数传递，与上面方法名称相同。
        //logger.info("创建节点返回结果：{}",result);
        //logger.info("完成创建节点：{}， 数据：{}",nodePath,nodeData);
    }

    public static Stat queryStat(ZooKeeper zk,String nodePath) throws KeeperException, InterruptedException{
        //logger.info("准备查询节点Stat，path：{}", nodePath);
        Stat stat = zk.exists(nodePath, false);
        //logger.info("结束查询节点Stat，path：{}，version：{}", nodePath, stat.getVersion());
        return stat;
    }
    /**
     * 描述：查询节点Data值信息
     * 作者：七脉
     * @param zk
     * @param nodePath
     * @return
     * @throws KeeperException
     * @throws InterruptedException
     */
    public static String queryData(ZooKeeper zk,String nodePath) throws KeeperException, InterruptedException{
        //logger.info("准备查询节点Data,path：{}", nodePath);
        String data = new String(zk.getData(nodePath, false, queryStat(zk, nodePath)));
        //logger.info("结束查询节点Data,path：{}，Data：{}", nodePath, data);
        return data;
    }
    /**
     * 描述：修改节点
     * 作者：七脉
     * @param zk
     * @param nodePath
     * @param nodeData
     * @throws KeeperException
     * @throws InterruptedException
     * 重点：每次修改节点的version版本号都会变更，所以每次修改都需要传递节点原版本号，以确保数据的安全性。
     */
    public static Stat update(ZooKeeper zk,String nodePath,String nodeData) throws KeeperException, InterruptedException{
        //修改节点前先查询该节点信息
        Stat stat = queryStat(zk, nodePath);
        //logger.info("准备修改节点，path：{}，data：{}，原version：{}", nodePath, nodeData, stat.getVersion());
        Stat newStat = zk.setData(nodePath, nodeData.getBytes(), stat.getVersion());
        //修改节点值有两种方法，上面是第一种，还有一种可以使用回调函数及参数传递，与上面方法名称相同。
        //zk.setData(path, data, version, cb, ctx);
        //logger.info("完成修改节点，path：{}，data：{}，现version：{}", nodePath, nodeData, newStat.getVersion());
        return stat;
    }
    /**
     * 描述：删除节点
     * 作者：七脉
     * @param zk
     * @param nodePath
     * @throws InterruptedException
     * @throws KeeperException
     */
    public static void delete(ZooKeeper zk,String nodePath) throws InterruptedException, KeeperException{
        //删除节点前先查询该节点信息
        Stat stat = queryStat(zk, nodePath);
        //logger.info("准备删除节点，path：{}，原version：{}", nodePath, stat.getVersion());
        zk.delete(nodePath, stat.getVersion());
        //修改节点值有两种方法，上面是第一种，还有一种可以使用回调函数及参数传递，与上面方法名称相同。
        //zk.delete(path, version, cb, ctx);
        //logger.info("完成删除节点，path：{}", nodePath);
    }


}
