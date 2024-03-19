package com.project.ssm.meetingroom.service;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.model.request.MeetingRoomAddReq;
import com.project.ssm.meetingroom.model.response.*;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MeetingRoomService {
    private final MeetingRoomRepository meetingRoomRepository;
    private final EventRepository eventRepository;

    // 회의실 생성
    public MeetingRoomAddResult createMeetingRoom(MeetingRoomAddReq request) {
        MeetingRoom meetingRoom = MeetingRoom.builder()
                .meetingRoomName(request.getRoomName())
                .meetingRoomCapacity(request.getRoomCapacity())
                .build();

        meetingRoom = meetingRoomRepository.save(meetingRoom);


        return MeetingRoomAddResult.builder()
                .idx(meetingRoom.getMeetingRoomIdx())
                .roomName(meetingRoom.getMeetingRoomName())
                .build();
    }

    // 회의실 단일 조회
    public MeetingSelectRes getMeetingRoom(Long meetingRoomIdx) {
        Optional<MeetingRoom> optionalMeetingRoom = meetingRoomRepository.findById(meetingRoomIdx);
        if (!optionalMeetingRoom.isPresent()) {
            return MeetingSelectRes.builder().build(); // 회의실이 없는 경우 빈 결과 반환 예외처리 구현 필요
        }
        MeetingRoom meetingRoom = optionalMeetingRoom.get();
        // 회의실 ID에 대한 모든 예약을 List 반환
        List<Event> eventsList = eventRepository.findByMeetingRoom(meetingRoom);
        // 정보 저장할 리스트 생성
        List<MeetingSelectResReservation> reservationList = new ArrayList<>();

        // 예약 정보 탐색
        // sharedEventIdx 를 어떻게 처리할 것인가. 일정등록이 추가된다면 같이 조회
        for (Event event : eventsList) {
            MeetingSelectResReservation reservationDetail = MeetingSelectResReservation.builder()
                    .eventIdx(event.getEventIdx())
                    .createdAt(event.getCreatedAt()) // 필요에 따라 포맷 변경
                    .startedAt(event.getStartedAt())
                    .closedAt(event.getClosedAt())
                    .build();
            reservationList.add(reservationDetail);
        }

        MeetingSelectResMeetingRoomSelectResult result = MeetingSelectResMeetingRoomSelectResult.builder() // 회의실 정보 저장
                .roomIdx(meetingRoom.getMeetingRoomIdx())
                .roomName(meetingRoom.getMeetingRoomName())
                .roomCapacity(meetingRoom.getMeetingRoomCapacity())
                .reservations(reservationList)                // 예약 정보
                .build();


        return MeetingSelectRes.builder()
                .result(result)
                .build();
    }

    // 회의실 전체 조회
    public List<MeetingRoomListRes> getAllMeetingRooms() {
        List<MeetingRoom> meetingRooms = meetingRoomRepository.findAll();
        List<MeetingRoomListRes> meetingRoomListResList = new ArrayList<>();

        // 미팅룸 전체 탐색 정보 저장
        for (MeetingRoom room : meetingRooms) {
            MeetingRoomListRes listRes = MeetingRoomListRes.builder()
                    .roomIdx(room.getMeetingRoomIdx())
                    .roomName(room.getMeetingRoomName())
                    .roomCapacity(room.getMeetingRoomCapacity())
                    .build();
            meetingRoomListResList.add(listRes);
        }
        return meetingRoomListResList;
    }



    public void deleteMeetingRoom(Long meetingRoomIdx) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(meetingRoomIdx);
        if (meetingRoomOptional.isPresent()) {
            meetingRoomRepository.delete(meetingRoomOptional.get());
        }
        // 회의실이 없으면 빈결과 반환 추후 예외처리 구현 필요
    }
}
