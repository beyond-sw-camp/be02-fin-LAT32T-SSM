package com.project.ssm.events.model.response;

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
