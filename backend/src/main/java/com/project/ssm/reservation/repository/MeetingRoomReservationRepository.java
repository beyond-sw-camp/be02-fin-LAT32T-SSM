package com.project.ssm.reservation.repository;

import com.project.ssm.reservation.model.MeetingReservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MeetingRoomReservationRepository extends JpaRepository<MeetingReservation,Long> {

    // 특정 회의실 ID에 해당하는 모든 예약 목록을 조회
    List<MeetingReservation> findByMeetingRoom_MeetingRoomIdx(Long meetingRoomIdx);

}
