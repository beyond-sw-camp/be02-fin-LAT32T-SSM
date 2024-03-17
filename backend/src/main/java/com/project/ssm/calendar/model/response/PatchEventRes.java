package com.project.ssm.calendar.model.response;

import com.project.ssm.calendar.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PatchEventRes {

    private Long eventIdx;

    private String title;
    private String startedAt;
    private String closedAt;
    private String eventContent;
    private String type;
    private String backgroundColor;
    private Boolean allDay;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime startedAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime closedAt;

    public static PatchEventRes buildEventRes(Event event) {
        return PatchEventRes.builder()
                .eventIdx(event.getEventIdx())
                .title(event.getTitle())
                .eventContent(event.getEventContent())
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .type(event.getType())
                .backgroundColor(event.getBackgroundColor())
                .allDay(event.getAllDay())
                .build();
    }
}
