package com.project.ssm.notification.controller;


import com.project.ssm.notification.service.EmittersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.http.MediaType;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;


@RestController
@Slf4j
@RequiredArgsConstructor
public class NotificationController {

    private final EmittersService emittersService;

    @RequestMapping(value = "/notification/{memberId}", method = RequestMethod.GET, produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public SseEmitter handle(@PathVariable String memberId) {
        SseEmitter emitter = new SseEmitter(3600000L);
        log.info("Emitter for client {}: {}", memberId, emitter);

        emittersService.getEmitters().put(memberId, emitter);

        emitter.onCompletion(() -> {
            log.info("Emitter completed for client {}", memberId);
            emittersService.getEmitters().remove(memberId);
        });

        emitter.onTimeout(() -> {
            log.info("Emitter timed out for client {}", memberId);
            emittersService.getEmitters().remove(memberId);
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
        emittersService.sendAlarmToClients(record.key(), record.value());
    }
}
