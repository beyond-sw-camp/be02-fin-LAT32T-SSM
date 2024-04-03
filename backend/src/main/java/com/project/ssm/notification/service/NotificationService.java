package com.project.ssm.notification.service;

import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NotificationService {
    private final EventRepository eventRepository;
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Transactional
    public void memberEventRead() {
        List<EventParticipants> memberByEventTime = eventRepository.findMemberByEventTime();
        for (EventParticipants eventParticipants : memberByEventTime) {
            ProducerRecord<String, Object> record =
                    new ProducerRecord<>("SseMessage",
                            ""+eventParticipants.getMember().getMemberId(),
                            eventParticipants.getEvent().getTitle() + " 일정이 곧 시작예정입니다.");
            kafkaTemplate.send(record);

//            sendAlarmToClients(eventParticipants.getMember().getMemberId(),
//                    eventParticipants.getEvent().getTitle() + " 일정이 곧 시작예정입니다.");
        }
    }
}
