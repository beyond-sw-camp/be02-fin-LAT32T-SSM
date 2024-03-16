package com.project.ssm.calendar.model.request;


import com.project.ssm.calendar.model.entity.Event;
import com.project.ssm.member.model.Member;
import lombok.*;

@Setter
@Getter
@Builder
public class PostEventReq {

    // private Long eventIdx;
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

//    private String priority;
//    private String isLooped;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime startedAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime closedAt;

//    public static Event postEventReqBuilder(
//            Member member,
//                                                     String title,
//                                                     String startedAt,
//                                                     String closedAt,
//                                                     String eventContent,
//                                                     String type,
//                                                     String memberName,
//                                                     String backgroundColor,
//                                                     String textColor,
//                                                     Boolean allDay
//                                                     ){
//        Event event = Event.builder()
//                .member(member)
//                .title(title)
////                .priority(priority)
////                .isLooped(isLooped)
//                .startedAt(startedAt)
//                .closedAt(closedAt)
//                .eventContent(eventContent)
//                .type(type)
//                .memberName(memberName)
//                .backgroundColor(backgroundColor)
//                .textColor(textColor)
//                .allDay(allDay)
//                .build();
//
//        return event;
//    }

}
