package com.project.ssm.events.repository;

import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventParticipantsRepository extends JpaRepository<EventParticipants,Long> {
    List<EventParticipants> findAllByMember_MemberId(String memberId);

    // 참조 데이터 삭제
    void deleteByEvent(Event event);

}
