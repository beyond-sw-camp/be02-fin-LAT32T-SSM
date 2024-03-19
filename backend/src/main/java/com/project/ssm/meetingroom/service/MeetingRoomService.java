package com.project.ssm.meetingroom.service;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.meetingroom.exception.MeetingDuplicateException;
import com.project.ssm.meetingroom.exception.MeetingRoomNotFoundException;
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

        Optional<MeetingRoom> existingMeetingRoom = meetingRoomRepository.findByMeetingRoomName(request.getRoomName());

        if (existingMeetingRoom.isPresent()) {
            throw new MeetingDuplicateException(ErrorCode.MEETINGROOM_DUPLOCATE, "이미 있는 회의실입니다.");
        }

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
            throw new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "회의실을 찾을 수 없습니다.");
        }
        MeetingRoom meetingRoom = optionalMeetingRoom.get();
        // 회의실 ID에 대한 모든 예약을 List 반환
        List<Event> eventsList = eventRepository.findByMeetingRoom(meetingRoom);
        // 정보 저장할 리스트 생성
        List<MeetingSelectResReservation> reservationList = new ArrayList<>();

        // 예약 정보 탐색
        for (Event event : eventsList) {
            MeetingSelectResReservation reservationDetail = MeetingSelectResReservation.builder()
                    .eventIdx(event.getEventIdx())
                    .createdAt(event.getCreatedAt())
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
        } else
            throw new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND,"회의실을 찾을 수 없습니다.");
    }
}
