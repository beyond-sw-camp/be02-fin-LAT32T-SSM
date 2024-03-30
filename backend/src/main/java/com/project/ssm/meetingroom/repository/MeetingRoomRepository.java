package com.project.ssm.meetingroom.repository;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {
    Optional<MeetingRoom> findByMeetingRoomName(String meetingRoomName);
}
