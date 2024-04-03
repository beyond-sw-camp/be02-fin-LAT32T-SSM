package com.project.batch.notification;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final NotificationController notificationController;

//     1분에 한번씩 메서드 실행
    @Scheduled(fixedRate = 60000)
    public void schedule(){

    }
}
