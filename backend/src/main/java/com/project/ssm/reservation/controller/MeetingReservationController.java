package com.project.ssm.reservation.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.reservation.model.request.MeetingRoomReservationReq;
import com.project.ssm.reservation.model.response.MeetingRoomReservationCancleRes;
import com.project.ssm.reservation.model.response.MeetingRoomReservationRes;
import com.project.ssm.reservation.service.MeetingRoomReservationService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/meetingroom")
@AllArgsConstructor
public class MeetingReservationController {
    private final MeetingRoomReservationService meetingRoomReservationService;

    @PostMapping("/reservation") // 회의실 예약
    public ResponseEntity<BaseResponse> reservationMeetingRoom(@RequestBody MeetingRoomReservationReq request) {
        MeetingRoomReservationRes response = meetingRoomReservationService.meetingRoomReservation(request);

        BaseResponse baseResponse = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_039")
                .message("회의실 예약이 되었습니다.")
                .result(response.getResult())
                .build();

        return ResponseEntity.ok().body(baseResponse);
    }
    @DeleteMapping("/reservation/delete/{reservationIdx}") // 예약 삭제
    public ResponseEntity<BaseResponse> reservationDeleteMeetingRoom(@PathVariable Long reservationIdx) {
        MeetingRoomReservationCancleRes response = meetingRoomReservationService.meetingRoomReservationCancel(reservationIdx);

                BaseResponse baseResponse = BaseResponse.builder()
                .isSuccess(true)
                .code("ROOM_049")
                .message("회의실 예약이 취소 되었습니다.")
                .result(response.getResult())
                .build();

        return ResponseEntity.ok().body(baseResponse);
    }
}
