package com.project.ssm.utils;

import com.project.ssm.notification.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class Scheduler {

    private final NotificationService notificationService;

/**
 *  기존 스케줄링 기능을 SCDF 스켈쥴링으로 변경함에 따라 기능 삭제 예정 *
 */

//    @Scheduled(fixedRate = 60000)
//    public void schedule(){
//        notificationService.memberEventRead();
//    }
}
