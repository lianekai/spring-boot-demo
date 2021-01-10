package com.lianekai.websocket.config;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.websocket.*;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author lianekai
 */
@Component
@Slf4j
@Service
@ServerEndpoint("/api/websocket/{sid}")
public class WebSocketServer {
    /**静态变量，记录当前连接数，应该把它设计成线程安全的*/
    private static int onlineCount=0;
    /**concurrent包的线程安全Set,用来存放每个客户端对应的WebSocket对象*/
    private static CopyOnWriteArraySet<WebSocketServer> webSocketSet= new CopyOnWriteArraySet<>();
    /**与某个客户端保持连接，需要用它来给客户端发送数据*/
    private Session session;
    /**接受sid*/
    private String sid;

    @OnOpen
    public void opnOpen(Session session,@PathParam("sid") String sid){
        this.session=session;
        /**加入到set*/
        webSocketSet.add(this);
        this.sid=sid;
        addOnlineCount();
        try{
            sendMessage("conn_success");
            log.info("有新窗口开始监听:" + sid + ",当前在线人数为:" + getOnlineCount());
        }catch (IOException e){
            log.error("WebSocket IO Exception");
        }


    }
    @OnClose
    public void Onclose(){
        webSocketSet.remove(this);
        subOnlineCount();
        //断开连接的情况下，更新主板占用情况为释放
        log.info("释放的sid为："+sid);
        //释放连接时，需要处理的业务
        log.info("有一连接断开时。当前在线人数为"+getOnlineCount());
    }

    @OnMessage
    public void OnMessage(String message,Session session){
        log.info("来自窗口的sid："+sid+"的信息"+message);
        //群发信息
        for(WebSocketServer item:webSocketSet){
            try{
                item.sendMessage(message);
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }

    @OnError
    public void OnError(Session session,Throwable error){
        log.error("发生错误");
        error.printStackTrace();
    }

    /**实现服务器主动推送*/
    public void sendMessage(String message) throws IOException{
        this.session.getBasicRemote().sendText(message);
    }

    /**群发自定义消息*/
    public static void sendInfo(String message, @PathParam("sid") String sid) throws IOException {
        log.info("推送消息到窗口" + sid + "，推送内容:" + message);

        for (WebSocketServer item : webSocketSet) {
            try {
                //这里可以设定只推送给这个sid的，为null则全部推送
                if (sid == null) {
//                    item.sendMessage(message);
                } else if (item.sid.equals(sid)) {
                    item.sendMessage(message);
                }
            } catch (IOException e) {
                continue;
            }
        }
    }

    public static synchronized int getOnlineCount() {
        return onlineCount;
    }

    public static synchronized void addOnlineCount() {
        WebSocketServer.onlineCount++;
    }

    public static synchronized void subOnlineCount() {
        WebSocketServer.onlineCount--;
    }

    public static CopyOnWriteArraySet<WebSocketServer> getWebSocketSet() {
        return webSocketSet;
    }

}