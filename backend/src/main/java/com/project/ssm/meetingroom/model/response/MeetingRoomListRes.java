package com.project.ssm.meetingroom.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomListRes {
    private Long roomIdx;
    private String roomName;
    private Integer roomCapacity;
}
