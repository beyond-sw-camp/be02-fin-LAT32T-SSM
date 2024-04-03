package com.project.batch.notification;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.JobParameters;
import org.springframework.batch.core.JobParametersBuilder;
import org.springframework.batch.core.launch.JobLauncher;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class BatchScheduler {

    private final JobLauncher jobLauncher;
    private final Job sendAlarmJob;

    @Scheduled(fixedRate = 60000) // 1분마다 실행
    public void runSendAlarmJob() {
        try {
            // JobParameters를 사용하여 각 실행마다 고유한 파라미터를 전달 (예: 현재 시간 ? 9시간?)
            JobParameters parameters = new JobParametersBuilder()
                    .addLong("time", System.currentTimeMillis())
                    .toJobParameters();

            // sendAlarmJob 실행
            jobLauncher.run(sendAlarmJob, parameters);

            log.info("sendAlarmJob executed successfully.");
        } catch (Exception e) {
            log.error("Failed to execute sendAlarmJob", e);
        }
    }
}