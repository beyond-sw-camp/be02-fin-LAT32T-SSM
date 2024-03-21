package com.project.ssm.meetingroom.model.response;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMeetingRoomRes {
    private Long meetingRoomIdx;
    private String meetingRoomName;
    private Integer meetingRoomCapacity;
    private Boolean isOccupied;
    private String createdAt;
    private String updatedAt;

    public static PostMeetingRoomRes buildMeetingRoomRes (MeetingRoom meetingRoom){
        return PostMeetingRoomRes.builder()
                .meetingRoomIdx(meetingRoom.getMeetingRoomIdx())
                .meetingRoomName(meetingRoom.getMeetingRoomName())
                .meetingRoomCapacity(meetingRoom.getMeetingRoomCapacity())
                //.isOccupied(meetingRoom.getIsOccupied())
                .createdAt(meetingRoom.getCreatedAt())
                .updatedAt(meetingRoom.getUpdatedAt())
                .build();
    }
}
