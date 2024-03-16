package com.project.ssm.meetingroom.repository;

import com.project.ssm.meetingroom.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface MeetingRoomRepository extends JpaRepository<MeetingRoom, Long> {

}
