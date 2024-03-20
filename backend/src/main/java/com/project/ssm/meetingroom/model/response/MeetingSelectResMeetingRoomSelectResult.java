package com.project.ssm.meetingroom.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class MeetingSelectResMeetingRoomSelectResult {
    private Long roomIdx;
    private String roomName;
    private Integer roomCapacity;
    private List<MeetingSelectResReservation> reservations;
}
