package com.mikael.demo.config;

import javax.websocket.Session;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @description:
 * @author: mikael
 * @data: 2020/11/14
 */
public class SessionPool {
    public static Map<String, Session> sessions = new ConcurrentHashMap<>();

    public static void close(String sessionId) {
        for (String userId : SessionPool.sessions.keySet()) {
            Session session = SessionPool.sessions.get(userId);
            if (sessionId.equals(SessionPool.sessions.get(session))) {
                sessions.remove(userId);
                break;
            }
        }
    }

    public static void save(String userId, Session session) {
        sessions.put(userId, session);
    }

    /**
     * 根据userId发送message
     *
     * @param message
     * @param session
     */
    public static void sendMessage(String message, Session session) {
        sessions.get(session.getId()).getAsyncRemote().sendText(message);
    }

    /**
     * 群发SessionPool中的链接
     *
     * @param message
     */
    public static void sendallMessage(String message) {
        for (String sessionId : SessionPool.sessions.keySet()) {
            SessionPool.sessions.get(sessionId).getAsyncRemote().sendText(message);

        }
    }

}
