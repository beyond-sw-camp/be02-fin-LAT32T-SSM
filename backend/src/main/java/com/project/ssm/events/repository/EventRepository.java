package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long>, EventCustomRepository {
    Optional<Event> findById(Long eventIdx);
    List<Event> findByMeetingRoom(MeetingRoom meetingRoom);
}
