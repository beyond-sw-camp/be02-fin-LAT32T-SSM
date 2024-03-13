package com.project.ssm.meetingroom.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class ReservationDetails {
    private Long reservationIdx;
    private Long sharedEventIdx;
    private LocalDateTime createdAt;
    private LocalDateTime closedAt;
}
