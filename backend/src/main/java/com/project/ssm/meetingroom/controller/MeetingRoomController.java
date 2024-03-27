package com.project.ssm.meetingroom.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.events.model.response.PostEventRes;
import com.project.ssm.meetingroom.model.request.PostMeetingRoomReq;
import com.project.ssm.meetingroom.model.request.PostReservationReq;
import com.project.ssm.meetingroom.model.response.*;
import com.project.ssm.meetingroom.service.MeetingRoomService;
import com.project.ssm.member.model.Member;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RestController
@RequestMapping("/meetingroom")
@AllArgsConstructor
public class MeetingRoomController {

    private final MeetingRoomService meetingRoomService;

    // 회의실 생성
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<BaseResponse<PostMeetingRoomRes>> createMeetingRoom(@RequestBody PostMeetingRoomReq request){
//        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(meetingRoomService.createMeetingRoom(request));
    }

    // 현재 회의실 조회
    @RequestMapping(method = RequestMethod.GET, value = "/current")
    public ResponseEntity<BaseResponse<GetCurrentMeetingRoomRes>> getCurrentMeetingRoom(){
        return ResponseEntity.ok().body(meetingRoomService.GetCurrentMeetingRoom());
    }

    // 회의실 조회

    @RequestMapping(method = RequestMethod.GET, value = "/select/{meetingRoomIdx}") // 회의실 단일 조회
    public ResponseEntity<BaseResponse> getMeetingRoom(@PathVariable Long meetingRoomIdx) {
        MeetingSelectRes details = meetingRoomService.getMeetingRoom(meetingRoomIdx);

        BaseResponse response = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_010")
                .message("회의실 및 예약 정보 조회를 성공하였습니다.")
                .result(details.getResult())
                .build();

        return ResponseEntity.ok().body(response);
    }


    @RequestMapping(method = RequestMethod.GET, value = "/list") // 회의실 전체 조회
    public ResponseEntity<BaseResponse> getAllMeetingRooms() {
        List<MeetingRoomListRes> meetingRooms = meetingRoomService.getAllMeetingRooms();
        BaseResponse response = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_031")
                .message("회의실 조회 요청을 정상적으로 처리하였습니다.")
                .result(meetingRooms)
                .build();
        return ResponseEntity.ok().body(response);
    }



    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{meetingRoomIdx}") // 회의실 삭제
    public ResponseEntity<BaseResponse> deleteMeetingRoom(@PathVariable Long meetingRoomIdx) {
        meetingRoomService.deleteMeetingRoom(meetingRoomIdx);

        BaseResponse response = BaseResponse.builder()
                .code("ROOM_032")
                .isSuccess(true)
                .message("회의실이 삭제되었습니다.")
                .build();

        return ResponseEntity.ok().body(response);
    }

}
