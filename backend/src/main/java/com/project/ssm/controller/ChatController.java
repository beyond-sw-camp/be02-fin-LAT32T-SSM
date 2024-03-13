package com.project.ssm.controller;

import com.project.ssm.model.request.ChatInfo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@Slf4j
public class ChatController {
    private final SimpMessagingTemplate messagingTemplate;

    @MessageMapping("/message")
    public void sendMessage(ChatInfo message) {
        log.info("username = {}", message.getUserName());
        log.info("message = {}", message.getMessage());
        messagingTemplate.convertAndSend("/room/message", message);
    }
}
