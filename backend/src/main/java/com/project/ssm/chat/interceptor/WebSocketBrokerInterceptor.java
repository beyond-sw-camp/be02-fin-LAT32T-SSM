package com.project.ssm.chat.interceptor;

import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.KafkaAdminClient;
import org.springframework.kafka.core.KafkaAdmin;
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
            // 연결 상태 확인

        } else if (StompCommand.SEND == commandType) {
            log.info("commandType2 = {}", commandType);
            // 메시지 내용 확인

        } else if (StompCommand.SUBSCRIBE == commandType) {
            log.info("commandType3 = {}", commandType);
            // 채팅방 구독할 때 확인
            log.info("세션 아이디 = {}", headerAccessor.getSessionId());

        }
        return message;
    }
}
