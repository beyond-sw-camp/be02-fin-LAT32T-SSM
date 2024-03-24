package com.project.ssm.meetingroom.model.request;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostMeetingRoomReq {
    private String meetingRoomName;
    private Integer meetingRoomCapacity;
    private Boolean isOccupied;
}
