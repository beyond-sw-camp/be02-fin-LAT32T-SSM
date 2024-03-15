package com.project.ssm.event.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.event.model.request.MeetingRoomReservationReq;
import com.project.ssm.event.model.response.MeetingRoomReservationCancelRes;
import com.project.ssm.event.model.response.MeetingRoomReservationRes;
import com.project.ssm.event.service.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class EventsController {
    private final EventsService eventsService;
    @PostMapping("/meetingroom/reservation") // 회의실 예약
    public ResponseEntity<BaseResponse> reservationMeetingRoom(@RequestBody MeetingRoomReservationReq request) {
        MeetingRoomReservationRes response = eventsService.meetingRoomReservation(request);

        BaseResponse baseResponse = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_039")
                .message("회의실 예약이 되었습니다.")
                .result(response.getResult())
                .build();

        return ResponseEntity.ok().body(baseResponse);
    }
    @DeleteMapping("/meetingroom/reservation/delete/{reservationIdx}") // 예약 삭제
    public ResponseEntity<BaseResponse> reservationDeleteMeetingRoom(@PathVariable Long reservationIdx) {
        MeetingRoomReservationCancelRes response = eventsService.meetingRoomReservationCancel(reservationIdx);

        BaseResponse baseResponse = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_049")
                .message("회의실 예약이 취소 되었습니다.")
                .result(response.getResult())
                .build();

        return ResponseEntity.ok().body(baseResponse);
    }

}
