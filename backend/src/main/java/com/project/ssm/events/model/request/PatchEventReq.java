package com.project.ssm.events.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;


@Setter
@Builder
@Getter
public class PatchEventReq {

    private Long eventIdx;

    private String title;
    private String startedAt;
    private String closedAt;
    private String eventContent;
    private String type;
    private String backgroundColor;
    private Boolean allDay;

}
