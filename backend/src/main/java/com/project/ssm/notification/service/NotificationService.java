package com.project.ssm.notification.service;

import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
@Slf4j
public class NotificationService {
    private final EventRepository eventRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Transactional
    public void memberEventRead() {
        List<EventParticipants> memberByEventTime = eventRepository.findMemberByEventTime();
        log.info("조회가 되었다 {}", memberByEventTime.isEmpty());
        for (EventParticipants eventParticipants : memberByEventTime) {
            ProducerRecord<String, Object> record =
                    new ProducerRecord<>("SseMessage",
                            ""+eventParticipants.getMember().getMemberId(),
                            eventParticipants.getEvent().getTitle() + " 일정이 곧 시작예정입니다.");
            kafkaTemplate.send(record);
            log.info("아이디 :{}의 일정입니다.",eventParticipants.getMember().getMemberId());

//            sendAlarmToClients(eventParticipants.getMember().getMemberId(),
//                    eventParticipants.getEvent().getTitle() + " 일정이 곧 시작예정입니다.");
        }
    }
}
