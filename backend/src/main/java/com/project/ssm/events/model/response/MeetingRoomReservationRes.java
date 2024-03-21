package com.project.ssm.events.model.response;


import lombok.Builder;

@Builder
public class MeetingRoomReservationRes {
    private MeetingRoomReservationResResult result;
    public static MeetingRoomReservationRes buildReservationRes(Long eventIdx, String meetingRoomName) {
        return MeetingRoomReservationRes.builder()
                .result(MeetingRoomReservationResResult.builder()
                .eventIdx(eventIdx)
                .roomName(meetingRoomName)
                .build())
                .build();
    }
}
