package com.project.ssm.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.UUID;

@Configuration
public class KafkaConfig {

    @Bean
    public String kafkaListenerGroupId() {
        // UUID 기반의 groupId 생성
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
    
    // 기존 Kafka 리스너 컨테이너 팩토리와 컨슈머 팩토리 설정...
}
