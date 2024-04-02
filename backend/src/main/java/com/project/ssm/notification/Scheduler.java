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

//     10초에 한번씩 메서드 실행
    @Scheduled(fixedRate = 10000)
    public void schedule(){
        notificationService.memberEventRead();
    }
}
