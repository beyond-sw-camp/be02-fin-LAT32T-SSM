package com.project.ssm.notification;

import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@Slf4j
@CrossOrigin("*")
@RequiredArgsConstructor
public class NotificationController {

    private static final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
    private final NotificationService notificationService;

    @RequestMapping(value = "/notification/{memberId}", method = RequestMethod.GET)
    public SseEmitter handle(@PathVariable String memberId) {
        SseEmitter emitter = new SseEmitter(1800000L);
        log.info("Emitter for client {}: {}", memberId, emitter);

        emitters.put(memberId, emitter);

        emitter.onCompletion(() -> emitters.remove(memberId));
        emitter.onTimeout(() -> emitters.remove(memberId));

        return emitter;
    }

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

    // 테스트용 맵핑
    @RequestMapping(value = "/notification/test", method = RequestMethod.GET)
    public ResponseEntity test() {
        notificationService.memberEventRead();
        return ResponseEntity.ok().body("ok");
    }

}
