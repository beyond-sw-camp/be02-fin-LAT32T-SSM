package com.project.ssm.chat.repository;

import com.project.ssm.chat.model.entity.RoomParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomParticipantsRepository extends JpaRepository<RoomParticipants, Long> {

    List<RoomParticipants> findAllByMemberId(String memberId);
}
