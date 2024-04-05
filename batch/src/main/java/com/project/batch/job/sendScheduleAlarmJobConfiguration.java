package com.project.batch.job;

import com.project.batch.events.model.EventParticipants;
import com.project.batch.events.repository.EventCustomRepository;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.KafkaTemplate;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@Slf4j
@RequiredArgsConstructor
@Configuration
public class sendScheduleAlarmJobConfiguration {
    private final JobBuilderFactory jobBuilderFactory;
    private final StepBuilderFactory stepBuilderFactory;
    private final KafkaTemplate<String, String> kafkaTemplate;
    private final EntityManager entityManager;

    private EventParticipantsReader eventParticipantsReader;

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
    public Step sendEventAlarmStep(ItemReader<EventParticipants> sendScheduleAlarmReader,
                                   ItemWriter<EventParticipants> sendAlarmWriter) {
        // Reader와 Writer를 사용하여 처리
        return stepBuilderFactory.get("sendEventAlarmStep")
                .<EventParticipants, EventParticipants>chunk(CHUNK_SIZE)
                .reader(sendScheduleAlarmReader)
                .writer(sendAlarmWriter)
                .allowStartIfComplete(true) // 이전 실행이 완료되기 전이었어도 시작 가능
                .build();
    }

    @Bean   // 만들어놓은 쿼리 dsl을 사용하여 reader
    @Transactional
    public ItemReader<EventParticipants> sendScheduleAlarmReader(EventCustomRepository eventRepositoryImpl) {
        return new EventParticipantsReader(eventRepositoryImpl.findMemberByEventTime());
    }

    // 카프카를 통해 알람전송
    @Bean
    @Transactional
    public ItemWriter<EventParticipants> sendAlarmWriter() {
        return list -> {
            for (EventParticipants eventParticipants : list) {
                String message = "당신의 " + eventParticipants.getEvent().getTitle() + " 일정이 시작 전입니다.";
                String memberId = eventParticipants.getMember().getMemberId();
                kafkaTemplate.send("notificationTopic", memberId, message);
            }
        };
    }

    // 직접 빈을 생성하여 주입
    @Bean
    public JPAQueryFactory jpaQueryFactory() {
        return new JPAQueryFactory(entityManager);
    }
}
