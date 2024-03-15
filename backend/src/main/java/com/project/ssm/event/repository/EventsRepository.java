package com.project.ssm.event.repository;

import com.project.ssm.event.model.Events;
import com.project.ssm.meetingroom.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventsRepository extends JpaRepository<Events,Long> {

    // ((se.startedAt < :closedAt AND se.closedAt > :startedAt)) 조건으로 예약 중복 방지
    // 겹치는 예약이 있으면 true를, 없으면 false를 반환
    @Query("SELECT CASE WHEN COUNT(se) > 0 THEN true ELSE false END FROM Events se WHERE se.meetingRoom.meetingRoomIdx = :meetingRoomIdx AND ((se.startedAt < :closedAt AND se.closedAt > :startedAt))")
    boolean isReservationDuplication(@Param("meetingRoomIdx") Long meetingRoomIdx, @Param("startedAt") LocalDateTime startedAt, @Param("closedAt") LocalDateTime closedAt);

    // MeetingRoom 엔티티를 받아 해당 회의실에서 이루어진 모든 이벤트를 List 형태로 반환
    List<Events> findByMeetingRoom(MeetingRoom meetingRoom);
}

