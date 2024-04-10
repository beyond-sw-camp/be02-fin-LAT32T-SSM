package com.project.ssm.events.controller;


import com.project.ssm.events.model.request.PatchEventReq;
import com.project.ssm.events.model.request.PatchReservationReq;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.events.model.response.*;
import com.project.ssm.events.service.EventService;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar/event")
public class EventController {
    private final EventService eventService;
    // 일정 등록
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity<Object> createEvent(@RequestBody PostEventReq request){
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.createEvent(member, request));
    }

    // 연간 일정 조회
    @RequestMapping(method = RequestMethod.GET, value = "/list")
    public ResponseEntity<Object> listEvents(
            @RequestParam(value = "startDate") String startDate,
            @RequestParam(value = "endDate") String endDate
    ){
        return ResponseEntity.ok().body(eventService.listEvents(startDate, endDate));
    }

    // 일정 상세 조회
    @RequestMapping(method = RequestMethod.GET, value = "/date/{date}")
    public ResponseEntity<Object> getEvent(@PathVariable String date) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.readEvent(member, date));
    }

    // 일정 수정
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity<Object> updateEvent(@RequestBody PatchEventReq request) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.updateEvent(member, request));
    }

    // 일정 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete/{eventIdx}")
    public ResponseEntity<Object> deleteEvent(@PathVariable Long eventIdx) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.deleteEvent(member, eventIdx));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/healthcheck")
    public ResponseEntity<Object> deleteEvent() {
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/reservation")
    public ResponseEntity<Object> createReservation(@RequestBody PatchReservationReq request){
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.createReservation(member, request));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/reservation/{meetingRoomIdx}/{date}")
    public ResponseEntity<Object> listReservations(@PathVariable String date, @PathVariable Long meetingRoomIdx){
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.listReservations(member, meetingRoomIdx, date));
    }

    // 회의실 예약 취소
    @RequestMapping(method = RequestMethod.DELETE, value = "/reservation/delete/{reservationIdx}")
    public ResponseEntity<BaseResponse<DeleteReservationCancelRes>> reservationDeleteMeetingRoom(@PathVariable Long reservationIdx) {
        return ResponseEntity.ok().body(eventService.meetingRoomReservationCancel(reservationIdx));
    }
}