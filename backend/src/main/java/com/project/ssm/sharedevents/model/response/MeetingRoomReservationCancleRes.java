package com.project.ssm.sharedevents.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomReservationCancleRes {
    public Result result;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Result {
        private Long meetingRoomIdx;
        private String roomName;
        private Integer roomNum;
        private Integer roomCapacity;
        private List<Reservation> reservations;
    }
    @Getter
    @Setter
    @Builder
    public static class Reservation {
        private Long reservationIdx;
        private String createdAt;
        private LocalDateTime startedAt;
        private LocalDateTime closedAt;

    }
}
