package com.project.ssm.sharedevents.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.sharedevents.model.request.MeetingRoomReservationReq;
import com.project.ssm.sharedevents.model.response.MeetingRoomReservationCancleRes;
import com.project.ssm.sharedevents.model.response.MeetingRoomReservationRes;
import com.project.ssm.sharedevents.service.SharedEventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/")
@AllArgsConstructor
public class SharedEventsController {
    private final SharedEventsService sharedEventsService;
    @PostMapping("/meetingroom/reservation") // 회의실 예약
    public ResponseEntity<BaseResponse> reservationMeetingRoom(@RequestBody MeetingRoomReservationReq request) {
        MeetingRoomReservationRes response = sharedEventsService.meetingRoomReservation(request);

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
        MeetingRoomReservationCancleRes response = sharedEventsService.meetingRoomReservationCancel(reservationIdx);

        BaseResponse baseResponse = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_049")
                .message("회의실 예약이 취소 되었습니다.")
                .result(response.getResult())
                .build();

        return ResponseEntity.ok().body(baseResponse);
    }

}
