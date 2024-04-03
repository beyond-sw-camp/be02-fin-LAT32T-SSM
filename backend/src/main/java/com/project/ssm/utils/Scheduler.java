package com.project.ssm.utils;

import com.project.ssm.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final NotificationService notificationService;

//     10초에 한번씩 메서드 실행
    @Scheduled(fixedRate = 20000)
    public void schedule(){
        notificationService.memberEventRead();
    }
}
