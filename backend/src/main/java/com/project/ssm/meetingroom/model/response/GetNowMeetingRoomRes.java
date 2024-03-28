package com.project.ssm.meetingroom.model.response;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class GetNowMeetingRoomRes {

    private Boolean isAvailable;
    private Long meetingRoomIdx;

    public static GetNowMeetingRoomRes buildMeetingRoomRes(MeetingRoom meetingRoom){
        return GetNowMeetingRoomRes.builder()
                .isAvailable(meetingRoom.getIsAvailable())
                .meetingRoomIdx(meetingRoom.getMeetingRoomIdx())
                .build();
    }

}
