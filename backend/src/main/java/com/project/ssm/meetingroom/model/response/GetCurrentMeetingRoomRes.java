package com.project.ssm.meetingroom.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetCurrentMeetingRoomRes {

    private String isAvailable;
    private Long meetingRoomIdx;

}
