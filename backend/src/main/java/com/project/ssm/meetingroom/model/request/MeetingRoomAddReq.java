package com.project.ssm.meetingroom.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class MeetingRoomAddReq {
    private String roomName;
    private Integer roomNum;
    private Integer roomCapacity;
}
