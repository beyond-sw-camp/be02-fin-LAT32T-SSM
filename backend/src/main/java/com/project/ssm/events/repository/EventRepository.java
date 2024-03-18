package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.meetingroom.model.MeetingRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long>, EventCustomRepository {
    Optional<Event> findById(Long eventIdx);

    // ((se.startedAt < :closedAt AND se.closedAt > :startedAt)) 조건으로 예약 중복 방지
    // 겹치는 예약이 있으면 true를, 없으면 false를 반환
    @Query("SELECT CASE WHEN COUNT(se) > 0 THEN true ELSE false END FROM Event se WHERE se.meetingRoom.meetingRoomIdx = :meetingRoomIdx AND ((se.startedAt < :closedAt AND se.closedAt > :startedAt))")
    boolean isReservationDuplication(@Param("meetingRoomIdx") Long meetingRoomIdx, @Param("startedAt") String startedAt, @Param("closedAt") String closedAt);

    // MeetingRoom 엔티티를 받아 해당 회의실에서 이루어진 모든 이벤트를 List 형태로 반환
    List<Event> findByMeetingRoom(MeetingRoom meetingRoom);
}
