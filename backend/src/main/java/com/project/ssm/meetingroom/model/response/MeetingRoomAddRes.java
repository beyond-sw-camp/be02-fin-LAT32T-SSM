package com.project.ssm.meetingroom.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomAddRes {
    private MeetingRoomAddResult result;
    @Getter
    @Setter
    @Builder
    public static class MeetingRoomAddResult {
        private Long idx;
        private String roomName;
    }
}
