package com.project.ssm.notification;

import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final NotificationService notificationService;
    @Scheduled(fixedRate = 10000)
    public void schedule(){
        notificationService.memberEventRead();
    }
}
