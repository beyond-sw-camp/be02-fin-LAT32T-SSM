package com.project.ssm.notification.service;

import lombok.Getter;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Service
@Getter
public class EmittersService {
    private final Map<String, SseEmitter> emitters = new ConcurrentHashMap<>();
}
