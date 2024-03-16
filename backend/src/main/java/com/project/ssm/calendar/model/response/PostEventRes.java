package com.project.ssm.calendar.model.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class PostEventRes {

    private Long eventIdx;
    private String title;
    private String startedAt;
    private String closedAt;
    private String eventContent;
    private String memberName;
    private Boolean allDay;
    private Long memberIdx;
}
