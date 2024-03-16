package com.project.ssm.calendar.model.request;

import com.project.ssm.member.model.Member;
import lombok.*;

@Setter
@Getter
@Builder
public class PostEventReq {

    private String title;
    private String startedAt;
    private String closedAt;
    private String eventContent;
    private String type;
    private String memberName;
    private String backgroundColor;
    private String textColor;
    private Boolean allDay;

    private Member member;

}
