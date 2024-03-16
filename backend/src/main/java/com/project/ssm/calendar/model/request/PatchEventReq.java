package com.project.ssm.calendar.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;


@Setter
@Builder
@Getter
public class PatchEventReq {

    private Long eventIdx;
    private Long memberIdx;
    private String title;
    private String priority;
    private String isLooped;

    private LocalDateTime startedAt;
    private LocalDateTime closedAt;

}
