package com.project.ssm.meetingroom.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.model.request.MeetingRoomAddReq;
import com.project.ssm.meetingroom.model.response.MeetingRoomAddRes;
import com.project.ssm.meetingroom.model.response.MeetingRoomDetailsRes;
import com.project.ssm.meetingroom.model.response.MeetingRoomListRes;
import com.project.ssm.meetingroom.model.response.MeetingSelectRes;
import com.project.ssm.meetingroom.service.MeetingRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/meetingroom")
@AllArgsConstructor
public class MeetingRoomController {

    private final MeetingRoomService meetingRoomService;

    @PostMapping("/add") // 회의실 추가
    public ResponseEntity<BaseResponse> addMeetingRoom(@RequestBody MeetingRoomAddReq request) {
        MeetingRoom meetingRoom = meetingRoomService.createMeetingRoom(request);

        MeetingRoomAddRes.MeetingRoomAddResult result = MeetingRoomAddRes.MeetingRoomAddResult.builder()
                .idx(meetingRoom.getRoomIdx())
                .roomName(meetingRoom.getRoomName())
                .build();


        BaseResponse response = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_001")
                .message("새로운 회의실이 생성되었습니다.")
                .result(result)
                .build();

        return ResponseEntity.ok(response);
    }

    @GetMapping("/select/{roomIdx}") // 회의실 단일 조회
    public ResponseEntity<BaseResponse> getMeetingRoom(@PathVariable Long roomIdx) {
        MeetingSelectRes details = meetingRoomService.getMeetingRoom(roomIdx);

        BaseResponse response = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_010")
                .message("회의실 및 예약 정보 조회를 성공하였습니다.")
                .result(details.getResult())
                .build();

        return ResponseEntity.ok(response);
    }



    @GetMapping("/list") // 회의실 전체 조회
    public ResponseEntity<BaseResponse> getAllMeetingRooms() {
        List<MeetingRoomListRes> meetingRooms = meetingRoomService.getAllMeetingRooms();
        BaseResponse response = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_031")
                .message("회의실 조회 요청을 정상적으로 처리하였습니다.")
                .result(meetingRooms)
                .build();
        return ResponseEntity.ok(response);
    }



//    @DeleteMapping("/delete/{roomIdx}") // 회의실 삭제
//    public ResponseEntity<BaseResponse> deleteMeetingRoom(@PathVariable Long roomIdx) {
//        meetingRoomService.deleteMeetingRoom(roomIdx);
//
//        BaseResponse response = BaseResponse.builder()
//                .code("ROOM_032")
//                .isSuccess(true)
//                .message("회의실이 삭제되었습니다.")
//                .build();
//
//        return ResponseEntity.ok(response);
//    }

}
