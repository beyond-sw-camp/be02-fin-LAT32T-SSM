package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@Builder
public class PatchEventRes {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private String startedAt;

    @NotBlank
    private String closedAt;

    @NotBlank
    @Size(max = 100)
    private String eventContent;

    @NotBlank
    private String type;

    @NotBlank
    private String backgroundColor;

    @NotBlank
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
