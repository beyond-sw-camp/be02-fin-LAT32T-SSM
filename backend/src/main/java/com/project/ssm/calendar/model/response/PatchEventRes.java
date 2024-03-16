package com.project.ssm.calendar.model.response;

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

}
