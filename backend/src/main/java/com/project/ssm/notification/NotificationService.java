package com.project.ssm.notification;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@RequiredArgsConstructor
public class NotificationService {
    private final KafkaTemplate kafkaTemplate;
    private final EventRepository eventRepository;

    @Transactional
    public void memberEventRead() {
        List<EventParticipants> memberByEventTime = eventRepository.findMemberByEventTime();
        for (EventParticipants eventParticipants : memberByEventTime) {
            ProducerRecord<String, String> record =
                    new ProducerRecord<>("ssetest",
                            ""+eventParticipants.getMember().getMemberId(),
                            eventParticipants.getEvent().getTitle() + " 일정이 곧 시작예정입니다.");
            kafkaTemplate.send(record);

//            sendAlarmToClients(eventParticipants.getMember().getMemberId(),
//                    eventParticipants.getEvent().getTitle() + " 일정이 곧 시작예정입니다.");
        }
    }
}
