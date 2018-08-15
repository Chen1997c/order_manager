package com.blank.config;

import org.springframework.context.annotation.Bean;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

/**
 * <p>
 *     功能描述:websocket配置
 * </p>
 *
 * @author :Team Blank
 * @since :2018.08.14
 */
public class WebSocketConfig {

    /**
     * 注入ServerEndpointExporter
     * 该bean会注自动册使用了@ServerEndpoint注解声明的Websocket endpoint
     *
     * @return
     */
    @Bean
    public ServerEndpointExporter serverEndpointExporter() {
        return new ServerEndpointExporter();
    }
}
