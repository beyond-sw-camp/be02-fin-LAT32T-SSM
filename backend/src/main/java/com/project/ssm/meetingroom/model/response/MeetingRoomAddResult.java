package com.project.ssm.meetingroom.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class MeetingRoomAddResult {
    private Long idx;
    private String roomName;
}