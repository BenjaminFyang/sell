package com.imooc.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArraySet;

/**
 * @author : Fy
 * @implSpec : Created with IntelliJ IDEA.
 * @date : 2018-03-05 18:10
 * @deprecated :
 */
@Component
@ServerEndpoint("/wevSocket")
@Slf4j
public class WebSocket {
    private Session session;

    private static CopyOnWriteArraySet<WebSocket> webSocketSet = new CopyOnWriteArraySet<>();

    @OnOpen
    public void opOpen(Session session) {
        this.session = session;
        webSocketSet.add(this);
        log.info("【webSocket消息】有新的连接，总数：{}", webSocketSet.size());
    }

    @OnClose
    public void onClose() {
        webSocketSet.remove(this);
        log.info("【webSocket消息】连接断开，总数：{}", webSocketSet.size());
    }

    @OnMessage
    public void onMessage(String message) {
        log.info("【webSocket消息】收到客户端发来的消息：{}", message);
    }

    /**
     * 发送消息
     *
     * @param message 需要发送的信息
     */
    public void sendMessage(String message) {
        for (WebSocket webSocket : webSocketSet) {
            log.info("【webSocket消息】广播消息，message={}", message);
            try {
                webSocket.session.getBasicRemote().sendText(message);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }


    }
}
