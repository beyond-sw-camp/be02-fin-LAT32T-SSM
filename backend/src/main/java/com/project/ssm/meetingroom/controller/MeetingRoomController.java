package com.project.ssm.meetingroom.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.meetingroom.model.request.PostMeetingRoomReq;
import com.project.ssm.meetingroom.model.response.*;
import com.project.ssm.meetingroom.service.MeetingRoomService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Object> createMeetingRoom(@RequestBody PostMeetingRoomReq request){
//        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(meetingRoomService.createMeetingRoom(request));
    }

    // 현재 회의실 조회
    @RequestMapping(method = RequestMethod.GET, value = "/current")
    public ResponseEntity<Object> getCurrentMeetingRoom(){
        return ResponseEntity.ok().body(meetingRoomService.GetCurrentMeetingRoom());
    }

    // 회의실 조회

    @RequestMapping(method = RequestMethod.GET, value = "/select/{meetingRoomIdx}") // 회의실 단일 조회
    public ResponseEntity<Object> getMeetingRoom(@PathVariable Long meetingRoomIdx) {
        return ResponseEntity.ok().body(meetingRoomService.getMeetingRoom(meetingRoomIdx));
    }


    @RequestMapping(method = RequestMethod.GET, value = "/list") // 회의실 전체 조회
    public ResponseEntity<Object> getAllMeetingRooms() {
        return ResponseEntity.ok().body(meetingRoomService.getAllMeetingRooms());
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{meetingRoomIdx}") // 회의실 삭제
    public ResponseEntity<Object> deleteMeetingRoom(@PathVariable Long meetingRoomIdx) {
        return ResponseEntity.ok().body(meetingRoomService.deleteMeetingRoom(meetingRoomIdx));
    }

}
