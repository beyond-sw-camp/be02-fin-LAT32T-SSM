package com.project.ssm.meetingroom.service;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.meetingroom.exception.MeetingRoomNotFoundException;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.meetingroom.model.request.PostMeetingRoomReq;
import com.project.ssm.meetingroom.model.response.*;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.meetingroom.utils.CurrentMeetingRoom;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MeetingRoomService {
    private final MeetingRoomRepository meetingRoomRepository;
    private final EventRepository eventRepository;
    private final CurrentMeetingRoom currentMeetingRoom;

    // 회의실 생성
    public BaseResponse<PostMeetingRoomRes> createMeetingRoom(PostMeetingRoomReq request) {
        meetingRoomRepository.findByMeetingRoomName(request.getMeetingRoomName()).orElseThrow(() ->
                MeetingRoomNotFoundException.forMeetingRoomName(request.getMeetingRoomName()));
        MeetingRoom meetingRoom = meetingRoomRepository.save(MeetingRoom.buildMeetingRoom(request));
        PostMeetingRoomRes response = PostMeetingRoomRes.buildMeetingRoomRes(meetingRoom);
        return BaseResponse.successRes("MEETING_000",true, "회의실이 생성되었습니다.",response);
    }

    // 현재 회의실 조회
    public BaseResponse<List<GetNowMeetingRoomRes>>GetCurrentMeetingRoom(){
        // 전제 미팅룸의 idx를 반복문으로 돌려
        List<MeetingRoom> allMeetingRooms = meetingRoomRepository.findAll();
        List<GetNowMeetingRoomRes> meetingRoomList = new ArrayList<>();
        for (MeetingRoom meetingRoom : allMeetingRooms) {
            meetingRoom = currentMeetingRoom.meetingRoomNow(meetingRoom.getMeetingRoomIdx());
            GetNowMeetingRoomRes response = GetNowMeetingRoomRes.buildMeetingRoomRes(meetingRoom);
            meetingRoomList.add(response);
        }
        return BaseResponse.successRes("MEETING_000",true, "회의실 현황 조회.",meetingRoomList);
    }

    // 회의실 단일 조회
    public BaseResponse<GetMeetingRoomSelectRes> getMeetingRoom(Long meetingRoomIdx) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(meetingRoomIdx).orElseThrow(() ->
                MeetingRoomNotFoundException.forMeetingRoomIdx());
        // 회의실 ID에 대한 모든 예약을 List 반환
        List<Event> eventsList = eventRepository.findByMeetingRoom(meetingRoom);
        // 정보 저장할 리스트 생성
        List<MeetingSelectResReservation> reservationList = new ArrayList<>();

        // 예약 정보 탐색
        for (Event event : eventsList) {
            MeetingSelectResReservation reservationDetail = MeetingSelectResReservation.buildSelectReservation(event);
            reservationList.add(reservationDetail);
        }
        GetMeetingRoomSelectRes result = GetMeetingRoomSelectRes.buildRoomSelectRes(meetingRoom, reservationList);
        return BaseResponse.successRes("MEETING_000", true, "회의실 예약 조회", result);
    }

    // 회의실 전체 조회
    public BaseResponse<List<MeetingRoomListRes>> getAllMeetingRooms() {
        List<MeetingRoom> meetingRooms = meetingRoomRepository.findAll();
        List<MeetingRoomListRes> meetingRoomListResList = new ArrayList<>();

        // 미팅룸 전체 탐색 정보 저장
        for (MeetingRoom room : meetingRooms) {
            MeetingRoomListRes listRes = MeetingRoomListRes.buildMeetingRoomListRes(room);
            meetingRoomListResList.add(listRes);
        }
        return BaseResponse.successRes("MEETING_000", true, "회의실 전체 조회", meetingRoomListResList);
    }

    public BaseResponse<String> deleteMeetingRoom(Long meetingRoomIdx) {
        MeetingRoom meetingRoom = meetingRoomRepository.findById(meetingRoomIdx).orElseThrow(() ->
                MeetingRoomNotFoundException.forMeetingRoomIdx());
        meetingRoomRepository.delete(meetingRoom);

        return BaseResponse.successRes("MEETING_000", true, "회의실 삭제 성공", "ok");
    }
}
