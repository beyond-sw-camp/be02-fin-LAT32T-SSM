package com.project.ssm.meetingroom.model.response;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GetMeetingRoomSelectRes {
    private Long roomIdx;
    private String roomName;
    private Integer roomCapacity;
    private List<MeetingSelectResReservation> reservations;

    public static GetMeetingRoomSelectRes buildRoomSelectRes(MeetingRoom meetingRoom, List<MeetingSelectResReservation> reservationList) {
        return GetMeetingRoomSelectRes.builder() // 회의실 정보 저장
                .roomIdx(meetingRoom.getMeetingRoomIdx())
                .roomName(meetingRoom.getMeetingRoomName())
                .roomCapacity(meetingRoom.getMeetingRoomCapacity())
                .reservations(reservationList)                // 예약 정보
                .build();
    }
}
