package com.mikael.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import java.net.Socket;

/**
 * @description:
 * @author: mikael
 * @data: 2020/11/13
 */
@Configuration
public class WebSocketConfig extends Socket {
    @Bean
    public ServerEndpointExporter server() {
        return new ServerEndpointExporter();

    }
}
