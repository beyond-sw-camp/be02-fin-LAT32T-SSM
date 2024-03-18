package com.project.ssm.calendar.model.response;

import com.project.ssm.calendar.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class DeleteReservationInfoRes {
    private Long eventIdx;
    private String createdAt;
    private String updatedAt;
    private String startedAt;
    private String closedAt;

    public static DeleteReservationInfoRes buildCancel(Event event) {
        return DeleteReservationInfoRes.builder()
                .eventIdx(event.getEventIdx())
                .createdAt(event.getCreatedAt())
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .build();
    }
}
