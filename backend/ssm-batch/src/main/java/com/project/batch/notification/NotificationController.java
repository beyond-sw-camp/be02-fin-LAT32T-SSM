package com.project.batch.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@RestController
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class NotificationController {

    private static final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();

    // 알람 발생 시 모든 클라이언트에게 알람 전송
    public static void sendAlarmToClients(List<String> memberIds, String message) {
        for (String memberId : memberIds) {
            System.out.println(emitters.get(memberId));
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

    @PostConstruct
    private void init() {
        emitters.put("default", new SseEmitter());
    }


}
