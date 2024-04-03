package com.project.batch.job;

import com.project.batch.notification.NotificationController;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.database.JdbcCursorItemReader;
import org.springframework.batch.item.database.builder.JdbcCursorItemReaderBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import javax.sql.DataSource;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class sendScheduleAlarmJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final DataSource dataSource;

    private static final int CHUNK_SIZE = 10000;

    @Bean
    public Job sendAlarmJob(
            Step sendEngagementAlarmStep,
            Step sendEventAlarmStep
    ) {
        return jobBuilderFactory.get("sendAlarmJob")
                .start(sendEngagementAlarmStep)
                .next(sendEventAlarmStep)
                .build();
    }

    @Bean
    public Step sendEngagementAlarmStep(
            ItemReader<sendScheduleAlarmReq> sendEngagementAlarmReader,
            ItemWriter<sendScheduleAlarmReq> sendAlarmWriter
    ) {
        // Reader와 Writer를 사용하여 처리
        return stepBuilderFactory.get("sendEngagementAlarmStep")
                .<sendScheduleAlarmReq, sendScheduleAlarmReq>chunk(CHUNK_SIZE)
                .reader(sendEngagementAlarmReader)
                .writer(sendAlarmWriter)
                .allowStartIfComplete(true) // 이전 실행이 완료되었어도 시작 가능
                .build();
    }

    @Bean
    public Step sendEventAlarmStep(
            ItemReader<sendScheduleAlarmReq> sendScheduleAlarmReader,
            ItemWriter<sendScheduleAlarmReq> sendAlarmWriter
    ) {
        return stepBuilderFactory.get("sendEventAlarmStep")
                .<sendScheduleAlarmReq, sendScheduleAlarmReq>chunk(CHUNK_SIZE)
                .reader(sendScheduleAlarmReader)
                .writer(sendAlarmWriter)
                .allowStartIfComplete(true)
                .build();
    }

    @Bean
    public JdbcCursorItemReader<sendScheduleAlarmReq> sendEngagementAlarmReader() {
        // 참여 요청이 수락된 사용자에 대한 정보를 읽어오는 Reader
        return new JdbcCursorItemReaderBuilder<sendScheduleAlarmReq>()
                .dataSource(dataSource)
                // started_at 형변환.
                .rowMapper(new BeanPropertyRowMapper<>(sendScheduleAlarmReq.class))
                .sql("SELECT event.* " +
                        "FROM event " +
                        "LEFT JOIN event_participants ON event.event_idx = event_participants.event_idx " +
                        "LEFT JOIN member ON event_participants.member_idx = member.member_idx " +
                        "WHERE event.started_at >= DATE_ADD(NOW(), INTERVAL 9 HOUR) + INTERVAL 1 MINUTE " +
                        "AND event.started_at <= DATE_ADD(NOW(), INTERVAL 9 HOUR) + INTERVAL 10 MINUTE ")
                .name("jdbcCursorItemReader")
                .build();
    }

    // 일정 작성자에게 알람을 보내기 위한 정보를 데이터베이스에서 읽어오는 Reader
    @Bean
    public JdbcCursorItemReader<sendScheduleAlarmReq> sendScheduleAlarmReader() {
        return new JdbcCursorItemReaderBuilder<sendScheduleAlarmReq>()
                .dataSource(dataSource)
                // started_at 형변환.
                .rowMapper(new BeanPropertyRowMapper<>(sendScheduleAlarmReq.class))
                .sql("SELECT event.* " +
                        "FROM event " +
                        "LEFT JOIN event_participants ON event.event_idx = event_participants.event_idx " +
                        "LEFT JOIN member ON member.member_idx = event.event_maker " + // 작성자 정보 조인
                        "WHERE event.started_at >= DATE_ADD(NOW(), INTERVAL 9 HOUR) + INTERVAL 1 MINUTE " + // 10분안에 시작하는 모든 일정 선택
                        "AND event.started_at <= DATE_ADD(NOW(), INTERVAL 9 HOUR) + INTERVAL 10 MINUTE; ")
                .name("jdbcCursorItemReader")
                .build();
    }

    // 스케줄러를 통해 알람전송
    @Bean
    public ItemWriter<sendScheduleAlarmReq> sendAlarmWriter() {
        return list -> {
            for (sendScheduleAlarmReq req : list) {
                String memberId = req.getMemberId();
                String message = "당신의 \"" + req.getTitle() + "\" 일정이 시작전입니다.";
                NotificationController.sendAlarmToClients(memberId, message);
            }
        };
    }
}
