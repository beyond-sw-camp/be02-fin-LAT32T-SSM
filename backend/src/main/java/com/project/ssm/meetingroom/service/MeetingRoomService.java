package com.project.ssm.meetingroom.service;

import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.model.request.MeetingRoomAddReq;
import com.project.ssm.meetingroom.model.response.MeetingRoomListRes;
import com.project.ssm.meetingroom.model.response.MeetingSelectRes;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.reservation.model.MeetingReservation;
import com.project.ssm.reservation.repository.MeetingRoomReservationRepository;
import com.project.ssm.sharedevents.model.SharedEvents;
import com.project.ssm.sharedevents.repository.SharedEventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

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
    public MeetingSelectRes getMeetingRoom(Long roomIdx) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(roomIdx)
                .orElseThrow(() -> new IllegalArgumentException("회의실을 찾을 수 없습니다"));

        List<MeetingReservation> reservations = meetingRoomReservationRepository.findByMeetingRoom_RoomIdx(roomIdx);
        List<Long> reservationIdxs = new ArrayList<>();
        List<MeetingSelectRes.Reservation> reservationList = new ArrayList<>();

        for (MeetingReservation reservation : reservations) {
            Set<SharedEvents> sharedEvents = reservation.getSharedEvents();
            for (SharedEvents sharedEvent : sharedEvents) {
                Long reservationIdx = reservation.getReservationIdx();

                // 예약 ID가 이미 추가된 예약 ID 목록에 포함되어 있지 않은지 확인
                if (!reservationIdxs.contains(reservationIdx)) {
                    reservationIdxs.add(reservationIdx);

                    reservationList.add(MeetingSelectRes.Reservation.builder()  // 예약idx 이벤트idx 조회해서 객체 생성
                            .reservationIdx(reservationIdx)
                            .sharedEventIdx(sharedEvent.getEventIdx())
                            .createdAt(reservation.getCreatedAt())
                            .startedAt(reservation.getStartedAt())
                            .closedAt(reservation.getClosedAt())
                            .build());
                }
            }
        }

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
        List<MeetingRoomListRes> meetingRoomListResList = new ArrayList<>();

        for (MeetingRoom room : meetingRooms) {
            MeetingRoomListRes listRes = MeetingRoomListRes.builder()
                    .roomIdx(room.getRoomIdx())
                    .roomName(room.getRoomName())
                    .roomNum(room.getRoomNum())
                    .roomCapacity(room.getRoomCapacity())
                    .roomStatus(room.getRoomStatus())
                    .build();
            meetingRoomListResList.add(listRes);
        }
        return meetingRoomListResList;
    }



//    public void deleteMeetingRoom(Long roomIdx) {
//        MeetingRoom meetingRoom = meetingRoomRepository.findById(roomIdx)
//                .orElseThrow(() -> new RuntimeException("회의실을 찾을 수 없습니다"));
//
//        meetingRoomRepository.delete(meetingRoom);
//    }
}
