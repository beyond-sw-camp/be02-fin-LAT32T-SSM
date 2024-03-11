package com.project.ssm.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.ChannelInterceptor;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class WebSocketBrokerInterceptor implements ChannelInterceptor {
    @Override
    public Message<?> preSend(Message<?> message, MessageChannel channel) {
        StompHeaderAccessor headerAccessor = StompHeaderAccessor.wrap(message);
        StompCommand commandType = headerAccessor.getCommand();
        if (StompCommand.CONNECT == commandType) {
            log.info("commandType1 = {}", commandType);
        } else if (StompCommand.SEND == commandType) {
            log.info("commandType2 = {}", commandType);
        } else if (StompCommand.SUBSCRIBE == commandType) {
            log.info("commandType3 = {}", commandType);
        }
        return message;
    }
}
