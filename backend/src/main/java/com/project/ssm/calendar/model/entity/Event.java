package com.project.ssm.calendar.model.entity;

import com.project.ssm.calendar.model.request.PatchEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventIdx;
    private String title;

    private String startedAt;
    private String closedAt;

    private String eventContent;
    private String type;
    private String memberName;
    private String backgroundColor;
    private String textColor;
    private Boolean allDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private Member member;

    public static Event buildEvent(Member member, PostEventReq request) {
        return Event.builder()
            .member(member)
            .title(request.getTitle())
            .startedAt(request.getStartedAt())
            .closedAt(request.getClosedAt())
            .eventContent(request.getEventContent())
            .type(request.getType())
            .memberName(member.getMemberName())
            .backgroundColor(request.getBackgroundColor())
            .textColor(request.getTextColor())
            .allDay(request.getAllDay())
            .build();
    }

    public static Event setEvent(PatchEventReq request, Event event){
        event.setTitle(request.getTitle());
        event.setEventContent(request.getEventContent());
        event.setStartedAt(request.getStartedAt());
        event.setClosedAt(request.getClosedAt());
        event.setType(request.getType());
        event.setBackgroundColor(request.getBackgroundColor());
        event.setAllDay(request.getAllDay());

        return event;
    }

}