package com.project.ssm.reservation.repository;

import com.project.ssm.reservation.model.MeetingReservation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MeetingRoomReservationRepository extends JpaRepository<MeetingReservation,Long> {

    // 특정 회의실 ID에 해당하는 모든 예약 목록을 조회
    List<MeetingReservation> findByMeetingRoom_MeetingRoomIdx(Long meetingRoomIdx);

    // ((r.startedAt < :closedAt AND r.closedAt > :startedAt)) 조건으로 예약 중복 방지
    @Query("SELECT CASE WHEN COUNT(r) > 0 THEN true ELSE false END FROM MeetingReservation r WHERE r.meetingRoom.meetingRoomIdx = :meetingRoomIdx AND ((r.startedAt < :closedAt AND r.closedAt > :startedAt))")
    boolean isReservationDuplication(@Param("meetingRoomIdx") Long meetingRoomIdx, @Param("startedAt") LocalDateTime startedAt, @Param("closedAt") LocalDateTime closedAt);

}
