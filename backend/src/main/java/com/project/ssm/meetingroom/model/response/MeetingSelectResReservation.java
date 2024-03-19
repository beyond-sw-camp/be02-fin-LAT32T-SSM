package com.project.ssm.meetingroom.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MeetingSelectResReservation {
    private Long eventIdx;
    private String createdAt;
    private LocalDateTime startedAt;
    private LocalDateTime closedAt;
}
