package com.project.batch.notification;

import com.project.batch.events.model.EventParticipants;
import com.project.batch.events.repository.EventRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;



@Service
@RequiredArgsConstructor
public class NotificationService {

    private final EventRepository eventRepository;
    private final KafkaTemplate<String, String> kafkaTemplate;


    @Transactional
    public void memberEventRead() {
        List<EventParticipants> memberByEventTime = eventRepository.findMemberByEventTime();
        for (EventParticipants eventParticipants : memberByEventTime) {
            String message = eventParticipants.getEvent().getTitle() + " 일정이 곧 시작 예정입니다.";
            String memberId = eventParticipants.getMember().getMemberId();
            kafkaTemplate.send("notificationTopic", memberId, message);
        }
    }
}
