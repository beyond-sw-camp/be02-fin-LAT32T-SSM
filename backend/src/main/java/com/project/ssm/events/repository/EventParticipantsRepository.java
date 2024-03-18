package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventParticipantsRepository extends JpaRepository<EventParticipants,Long> {
    // 참조 데이터 삭제
    void deleteByEvent(Event event);

}
