package com.project.ssm.calendar.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomReservationRes {
    private Result result;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Result {
        private Long eventIdx;
        private String roomName;
    }

    public static MeetingRoomReservationRes buildReservationRes(Long eventIdx, String meetingRoomName) {
        return MeetingRoomReservationRes.builder()
                .result(MeetingRoomReservationRes.Result.builder()
                .eventIdx(eventIdx)
                .roomName(meetingRoomName)
                .build())
                .build();
    }
}
