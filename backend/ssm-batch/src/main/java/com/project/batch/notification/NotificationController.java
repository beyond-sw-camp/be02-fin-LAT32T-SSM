package com.project.batch.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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




    // 알람 발생 시 모든 클라이언트에게 알람 전송
    public static void sendAlarmToClients(String memberId ,String message) {
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
