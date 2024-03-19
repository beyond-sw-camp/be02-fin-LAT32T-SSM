package com.project.ssm.meetingroom.model.response;

import lombok.*;


import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingSelectRes {
    private MeetingRoomSelectResult result;

    @Getter
    @Setter
    @Builder
    public static class MeetingRoomSelectResult {
        private Long roomIdx;
        private String roomName;
        private Integer roomCapacity;
        private List<Reservation> reservations;
    }

    @Getter
    @Setter
    @Builder
    public static class Reservation {
        private Long eventIdx;
        private String createdAt;
        private String startedAt;
        private String closedAt;
    }
}
