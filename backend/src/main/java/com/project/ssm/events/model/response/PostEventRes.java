package com.project.ssm.events.model.response;


import com.project.ssm.events.model.entity.Event;
import com.project.ssm.member.model.Member;
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

    private String type;


    public static PostEventRes buidEventRes(Event event, Member member) {
        return PostEventRes.builder()
                .eventIdx(event.getEventIdx())
                .memberIdx(member.getMemberIdx())
                .memberName(member.getMemberName())
                .title(event.getTitle())
                .eventContent(event.getEventContent())
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .allDay(event.getAllDay())
                .type(event.getType())
                .build();
    }
}
