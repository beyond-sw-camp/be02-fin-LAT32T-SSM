package com.project.ssm.notification.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
public class EmittersService {
    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    public void sendAlarmToClients(String memberId ,String message) {
        SseEmitter emitter = emitters.get(memberId);
        if (emitter != null) {
            try {
                emitter.send(SseEmitter.event().name("notification").data(message));
            } catch (IOException e) {
                emitters.remove(memberId);
            }
        }
    }
}
