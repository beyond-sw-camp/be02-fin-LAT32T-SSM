package com.project.ssm.meetingroom.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class MeetingSelectResReservation {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    private String createdAt;

    @NotBlank
    private String startedAt;

    @NotBlank
    private String closedAt;

    public static MeetingSelectResReservation buildSelectReservation(Event event) {
        return MeetingSelectResReservation.builder()
                .eventIdx(event.getEventIdx())
                .createdAt(event.getCreatedAt())
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .build();
    }
}
