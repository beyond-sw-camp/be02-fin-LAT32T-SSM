package com.project.ssm.meetingroom.service;

import com.project.ssm.meetingroom.dto.ReservationDetails;
import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.model.request.MeetingRoomAddReq;
import com.project.ssm.meetingroom.model.response.MeetingRoomListRes;
import com.project.ssm.meetingroom.model.response.MeetingSelectRes;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.reservation.model.MeetingReservation;
import com.project.ssm.reservation.repository.MeetingRoomReservationRepository;
import com.project.ssm.sharedevents.repository.SharedEventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MeetingRoomService {
    private final MeetingRoomRepository meetingRoomRepository;
    private final MeetingRoomReservationRepository meetingRoomReservationRepository;
    private final SharedEventsRepository sharedEventsRepository;

    // 회의실 생성
    public MeetingRoom createMeetingRoom(MeetingRoomAddReq request) {
        MeetingRoom meetingRoom = MeetingRoom.builder()
                .roomName(request.getRoomName())
                .roomNum(request.getRoomNum())
                .roomCapacity(request.getRoomCapacity())
                .roomStatus(true)
                .build();

        return meetingRoomRepository.save(meetingRoom);
    }

    // 회의실 단일 조회
    public MeetingSelectRes getMeetingRoomDetailsWithReservations(Long roomIdx) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(roomIdx)
                .orElseThrow(() -> new IllegalArgumentException("Meeting room not found"));

        List<MeetingReservation> reservations = meetingRoomReservationRepository.findByMeetingRoom_RoomIdx(roomIdx);

        List<MeetingSelectRes.Reservation> reservationList = reservations.stream()
                .distinct()
                .flatMap(reservation -> reservation.getSharedEvents().stream())
                .distinct()
                .map(sharedEvent -> MeetingSelectRes.Reservation.builder()
                        .reservationIdx(sharedEvent.getReservation().getReservationIdx())
                        .sharedEventIdx(sharedEvent.getEventIdx())
                        .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                        .closedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                        .build())
                .collect(Collectors.toList());

        MeetingSelectRes.MeetingRoomSelectResult result = MeetingSelectRes.MeetingRoomSelectResult.builder()
                .roomIdx(meetingRoom.getRoomIdx())
                .roomName(meetingRoom.getRoomName())
                .roomNum(meetingRoom.getRoomNum())
                .roomCapacity(meetingRoom.getRoomCapacity())
                .reservations(reservationList)
                .build();

        return MeetingSelectRes.builder()
                .result(result)
                .build();
    }

    // 회의실 전체 조회
    public List<MeetingRoomListRes> getAllMeetingRooms() {
        List<MeetingRoom> meetingRooms = meetingRoomRepository.findAll();
        return meetingRooms.stream()
                .map(room -> MeetingRoomListRes.builder()
                        .roomIdx(room.getRoomIdx())
                        .roomName(room.getRoomName())
                        .roomNum(room.getRoomNum())
                        .roomCapacity(room.getRoomCapacity())
                        .roomStatus(room.getRoomStatus())
                        .build())
                .collect(Collectors.toList());
    }

    // 회의실 삭제
    public void deleteMeetingRoom(Long roomIdx) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(roomIdx)
                .orElseThrow(() -> new RuntimeException("회의실을 찾을 수 없습니다"));

        meetingRoomRepository.delete(meetingRoom);
    }
}
