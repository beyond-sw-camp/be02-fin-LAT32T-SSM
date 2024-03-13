package com.project.ssm.calendar.controller;


import com.project.ssm.calendar.model.request.PostPersonalEventReq;
import com.project.ssm.calendar.service.PersonalEventService;
import com.project.ssm.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar/event")
public class PersonalEventController {
    private final PersonalEventService personalEventService;

    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createEvent(@RequestPart PostPersonalEventReq request, @RequestPart String memberId){

        BaseResponse response = personalEventService.create(request, memberId);

        return ResponseEntity.ok(response);
    }
}
