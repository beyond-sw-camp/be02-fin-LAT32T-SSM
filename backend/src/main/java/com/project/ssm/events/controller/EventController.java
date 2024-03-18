package com.project.ssm.events.controller;


import com.project.ssm.events.model.request.PatchEventReq;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.events.model.response.*;
import com.project.ssm.events.service.EventService;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.events.model.request.MeetingRoomReservationReq;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar/event")
@CrossOrigin("*")
public class EventController {
    private final EventService eventService;
    // 일정 등록
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<BaseResponse<PostEventRes>> createEvent(@RequestBody PostEventReq request){
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.create(member, request));
    }

    // 일정 상세 조회
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public ResponseEntity<BaseResponse<GetEventRes>> getEvent(@RequestParam Long eventIdx) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.read(member, eventIdx));
    }

    // 연간 일정 조회
    @RequestMapping(method = RequestMethod.GET, value = "/{year}")
    public ResponseEntity<BaseResponse<List<GetEventRes>>> listEvents(@PathVariable int year){
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.list(member, year));
    }

    // 일정 수정
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity<BaseResponse<PatchEventRes>> updateEvent(@RequestBody PatchEventReq request) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.update(member, request));
    }

    // 일정 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity<BaseResponse<DeleteEventRes>> deleteEvent(@RequestParam Long eventIdx) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.delete(member, eventIdx));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/reservation")
    public ResponseEntity<BaseResponse<MeetingRoomReservationRes>> reservationMeetingRoom(@RequestBody MeetingRoomReservationReq request) {
        return ResponseEntity.ok().body(eventService.meetingRoomReservation(request));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/reservation/delete/{reservationIdx}")
    public ResponseEntity<BaseResponse<DeleteReservationCancelRes>> reservationDeleteMeetingRoom(@PathVariable Long reservationIdx) {
        return ResponseEntity.ok().body(eventService.meetingRoomReservationCancel(reservationIdx));
    }
}