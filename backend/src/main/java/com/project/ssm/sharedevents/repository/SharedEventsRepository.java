package com.project.ssm.sharedevents.repository;

import com.project.ssm.sharedevents.model.SharedEvents;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;

public interface SharedEventsRepository extends JpaRepository<SharedEvents,Long> {

    // ((se.startedAt < :closedAt AND se.closedAt > :startedAt)) 조건으로 예약 중복 방지
    @Query("SELECT CASE WHEN COUNT(se) > 0 THEN true ELSE false END FROM SharedEvents se WHERE se.reservation.meetingRoom.meetingRoomIdx = :meetingRoomIdx AND ((se.startedAt < :closedAt AND se.closedAt > :startedAt))")
    boolean isReservationDuplication(@Param("meetingRoomIdx") Long meetingRoomIdx, @Param("startedAt") LocalDateTime startedAt, @Param("closedAt") LocalDateTime closedAt);
}

