package com.project.ssm.event.model.response;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomReservationCancelRes {
    private Result result;

    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    @Builder
    public static class Result {
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
        private LocalDateTime updatedAt;
        private LocalDateTime startedAt;
        private LocalDateTime closedAt;
    }
}

