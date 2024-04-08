package com.project.ssm.notification.controller;


import com.project.ssm.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


@RestController
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class NotificationController {

    private static final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
    private final NotificationService notificationService;

    @RequestMapping(value = "/notification/{memberId}", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter handle(@PathVariable String memberId) {
        SseEmitter emitter = new SseEmitter(150000L);
        log.info("Emitter for client {}: {}", memberId, emitter);

        emitters.put(memberId, emitter);

        emitter.onCompletion(() -> {
            log.info("Emitter completed for client {}", memberId);
            emitters.remove(memberId);
        });

        emitter.onTimeout(() -> {
            log.info("Emitter timed out for client {}", memberId);
            emitters.remove(memberId);
        });

        try {
            emitter.send(SseEmitter.event()
                    .name("test")
                    .data("SseEmitter 생성"));
        } catch (IOException e) {
            log.info("처음 이미터 보낼때 발생");
            throw new RuntimeException(e);
        }

        return emitter;
    }
    @KafkaListener(topics = "notificationTopic", groupId = "#{@kafkaListenerGroupId}")
    public void sendAlarmToClients(ConsumerRecord<String, String> record) {
        SseEmitter emitter = emitters.get(record.key());
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("notification").data(record.value()));
            } catch (IOException e) {
                log.info("카프카 데이터 보낼때 에러 발생");
                emitters.remove(record.key());
            }
        }
    }
}
