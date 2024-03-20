package com.project.ssm.meetingroom.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.meetingroom.model.request.MeetingRoomAddReq;
import com.project.ssm.meetingroom.model.response.MeetingRoomAddRes;
import com.project.ssm.meetingroom.model.response.MeetingRoomAddResult;
import com.project.ssm.meetingroom.model.response.MeetingRoomListRes;
import com.project.ssm.meetingroom.model.response.MeetingSelectRes;
import com.project.ssm.meetingroom.service.MeetingRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@CrossOrigin("*")
@RestController
@RequestMapping("/meetingroom")
@AllArgsConstructor
public class MeetingRoomController {

    private final MeetingRoomService meetingRoomService;

    @RequestMapping(method = RequestMethod.POST, value = "/add") // 회의실 추가
    public ResponseEntity<BaseResponse> addMeetingRoom(@RequestBody MeetingRoomAddReq request) {
        MeetingRoomAddResult result = meetingRoomService.createMeetingRoom(request);

        BaseResponse response = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_001")
                .message("새로운 회의실이 생성되었습니다.")
                .result(result)
                .build();

        return ResponseEntity.ok().body(response);
    }

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
