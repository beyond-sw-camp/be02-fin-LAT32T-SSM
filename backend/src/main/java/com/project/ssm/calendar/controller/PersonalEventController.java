package com.project.ssm.calendar.controller;


import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.calendar.model.request.DeletePersonalEventReq;
import com.project.ssm.calendar.model.request.GetPersonalEventReq;
import com.project.ssm.calendar.model.request.PatchPersonalEventReq;
import com.project.ssm.calendar.model.request.PostPersonalEventReq;
import com.project.ssm.calendar.service.PersonalEventService;
import com.project.ssm.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar/event")
public class PersonalEventController {
    private final PersonalEventService personalEventService;

    // 일정 등록
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createEvent(@RequestPart PostPersonalEventReq request, @RequestPart String memberId){

        BaseResponse response = personalEventService.create(request, memberId);

        return ResponseEntity.ok(response);
    }

    // 연간 일정 조회
    @RequestMapping(method = RequestMethod.GET, value = "/{year}")
    public ResponseEntity getEventsByYear(@PathVariable int year, @RequestParam String memberId) {

        BaseResponse response = personalEventService.findByYear(year,memberId);
        // List<PersonalEvent> events = personalEventService.findByYear(year,memberId);
        return ResponseEntity.ok(response);
    }

    // 일정 상세 조회
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public ResponseEntity getEvent(@RequestBody GetPersonalEventReq request) {

        BaseResponse response = personalEventService.findByEventIdx(request);
        // List<PersonalEvent> events = personalEventService.findByYear(year,memberId);
        return ResponseEntity.ok(response);
    }

    // 일정 수정
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity getEvent(@RequestBody PatchPersonalEventReq request) {

        BaseResponse response = personalEventService.updateEvent(request);

        return ResponseEntity.ok(response);
    }

    // 일정 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity getEvent(@RequestBody DeletePersonalEventReq request) {

        BaseResponse response = personalEventService.deleteEvent(request);

        return ResponseEntity.ok(response);
    }

}