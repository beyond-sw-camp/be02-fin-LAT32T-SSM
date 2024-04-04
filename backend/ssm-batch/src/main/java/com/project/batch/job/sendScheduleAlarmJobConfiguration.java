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
import org.springframework.jdbc.core.RowMapper;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.List;

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
            Step sendEventAlarmStep
    ) {
        return jobBuilderFactory.get("sendAlarmJob")
                .start(sendEventAlarmStep)
                .build();
    }

    @Bean
    public Step sendEventAlarmStep(
            ItemReader<sendScheduleAlarmReq> sendScheduleAlarmReader,
            ItemWriter<sendScheduleAlarmReq> sendAlarmWriter
    ) {
        // Reader와 Writer를 사용하여 처리
        return stepBuilderFactory.get("sendEventAlarmStep")
                .<sendScheduleAlarmReq, sendScheduleAlarmReq>chunk(CHUNK_SIZE)
                .reader(sendScheduleAlarmReader)
                .writer(sendAlarmWriter)
                .allowStartIfComplete(true) // 이전 실행이 완료되었어도 시작 가능
                .build();
    }

    @Bean
    public JdbcCursorItemReader<sendScheduleAlarmReq> sendScheduleAlarmReader() {
        // 일정 참여 요청이 수락된 사용자에 대한 정보를 읽어오는 Reader
        return new JdbcCursorItemReaderBuilder<sendScheduleAlarmReq>()
                .dataSource(dataSource)
                .rowMapper(new RowMapper<sendScheduleAlarmReq>() {
                    @Override
                    public sendScheduleAlarmReq mapRow(ResultSet resultSet, int rowNum) throws SQLException {
                        sendScheduleAlarmReq req = new sendScheduleAlarmReq();
                        // started_at 컬럼의 문자열 값을 LocalDateTime으로 변환하여 설정
                        String startedAtString = resultSet.getString("started_at");
                        LocalDateTime startedAt = null;
                        try {
                            // 초까지 포함
                            startedAt = LocalDateTime.parse(startedAtString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
                        } catch (DateTimeParseException e) {
                            // 만약 초까지 파싱이 실패하면 다른 형식으로 다시 시도
                            try {
                                // 분까지만
                                startedAt = LocalDateTime.parse(startedAtString, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
                            } catch (DateTimeParseException ex) {
                                // 그래도 없으면
                                startedAt = null;
                            }
                        }
                        req.setStartedAt(startedAt);
                        req.setMemberId(resultSet.getString("member_id"));
                        // 멤버 받아오는지 확인
                        // System.out.println(req.getMemberId());
                        return req;
                    }
                })
                // 참가 테이블을 통해 멤버 idx를 조회해온다.
                .sql("SELECT event.*, member.member_id " +
                        "FROM event " +
                        "LEFT JOIN event_participants ON event.event_idx = event_participants.event_idx " +
                        "LEFT JOIN member ON event_participants.member_idx = member.member_idx " +  // 작성자 정보 조인
                        "WHERE event.started_at >= DATE_ADD(NOW(), INTERVAL 9 HOUR) + INTERVAL 1 MINUTE " + // 10분안에 시작하는 모든 일정 선택
                        "AND event.started_at <= DATE_ADD(NOW(), INTERVAL 9 HOUR) + INTERVAL 10 MINUTE "
                )
                .name("jdbcCursorItemReader")
                .build();
    }

    // 스케줄러를 통해 알람전송
    @Bean
    public ItemWriter<sendScheduleAlarmReq> sendAlarmWriter() {
        return list -> {
            List<String> memberIds = new ArrayList<>();
            String message = null;
            for (sendScheduleAlarmReq req : list) {
                message = "당신의 " + req.getTitle() +  " 일정이 시작전입니다.";
                memberIds.add(req.getMemberId());
                System.out.println(req.getMemberId());
            }
            NotificationController.sendAlarmToClients(memberIds, message);
        };
    }
}

