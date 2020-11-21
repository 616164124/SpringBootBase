package com.mikael.demo.config;

import org.springframework.stereotype.Component;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;
import java.io.IOException;

/**
 * @description:
 * @author: mikael
 * @data: 2020/11/14
 */
@Component
@ServerEndpoint("/websocket/{userId}")
public class WebSocketEndpoint {

    /**
     *
     */
    private Session session;

    /**
     * 开启连接
     * @param session
     * @param userId
     */
    @OnOpen
    public void openSession(Session session, @PathParam("userId") String userId) {
        SessionPool.save(userId, session);
    }

    /**
     * 关闭连接
     * @param session
     * @throws IOException
     */
    @OnClose
    public void closeSession(Session session) throws IOException {
        SessionPool.close(session.getId());
        session.close();
    }

    @OnMessage
    public void sendMessage(String message, Session session) {
        SessionPool.sendMessage(message, session);
    }

}
