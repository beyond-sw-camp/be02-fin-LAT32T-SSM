package com.project.ssm.chat.service;

import com.project.ssm.chat.model.request.SendMessageReq;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.config.ConcurrentKafkaListenerContainerFactory;
import org.springframework.kafka.config.MethodKafkaListenerEndpoint;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;
import org.springframework.kafka.listener.ConcurrentMessageListenerContainer;
import org.springframework.kafka.listener.MessageListener;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
@Slf4j
public class KafkaService {

    private final SimpMessagingTemplate messagingTemplate;
    private final ConcurrentKafkaListenerContainerFactory<String, SendMessageReq> kafkaListenerContainerFactory;
    private final KafkaAdmin kafkaAdmin;

    public void registerNewChatRoomListener(String chatRoomId) {
        NewTopic topic = TopicBuilder.name(chatRoomId).build();
        kafkaAdmin.createOrModifyTopics(topic);

        ConcurrentMessageListenerContainer<String, SendMessageReq> container = kafkaListenerContainerFactory.createContainer(chatRoomId);
        container.setupMessageListener((MessageListener<String, SendMessageReq>) recode -> {
            log.info("chatRoomId {} - message {}", chatRoomId, recode.value());
            messagingTemplate.convertAndSend("/sub/room/" + chatRoomId, recode.value());
        });
        container.start();
    }
}
