package com.project.ssm.chat.config;

import com.project.ssm.chat.model.request.SendMessageReq;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListenerConfigurer;
import org.springframework.kafka.config.KafkaListenerEndpoint;
import org.springframework.kafka.config.KafkaListenerEndpointRegistrar;
import org.springframework.kafka.config.KafkaListenerEndpointRegistry;
import org.springframework.kafka.config.MethodKafkaListenerEndpoint;

@Configuration
public class KafkaConfig implements KafkaListenerConfigurer {

    @Override
    public void configureKafkaListeners(KafkaListenerEndpointRegistrar kafkaListenerEndpointRegistrar) {
        MethodKafkaListenerEndpoint<String, SendMessageReq> endpoint = new MethodKafkaListenerEndpoint<>();
        endpoint.setId("chatRoom-Listener");
        endpoint.setTopics("");
        endpoint.setGroupId("");



    }


}
