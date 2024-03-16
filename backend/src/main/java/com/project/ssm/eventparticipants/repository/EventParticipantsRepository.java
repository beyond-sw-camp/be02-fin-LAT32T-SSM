package com.project.ssm.eventparticipants.repository;

import com.project.ssm.event.model.Events;
import com.project.ssm.eventparticipants.model.EventParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventParticipantsRepository extends JpaRepository<EventParticipants,Long> {
    // 참조 데이터 삭제
    void deleteByEvent(Events event);

}
