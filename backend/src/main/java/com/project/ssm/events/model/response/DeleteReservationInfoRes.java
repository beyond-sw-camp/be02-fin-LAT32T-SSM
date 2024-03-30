package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Getter
@Setter
@Builder
public class DeleteReservationInfoRes {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    private String createdAt;

    @NotBlank
    private String updatedAt;

    @NotBlank
    private String startedAt;

    @NotBlank
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
