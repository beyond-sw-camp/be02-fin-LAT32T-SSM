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
    private String type;
    private String memberName;
    private String backgroundColor;
    private String textColor;
    private Boolean allDay;

    private Long memberIdx;

//    public static PostEventRes postEventResBuilder(
//            Long memberIdx,
//                                                                   Long eventIdx,
//                                                                   String title,
//                                                                   String startedAt,
//                                                                   String closedAt,
//                                                                   String eventContent,
//                                                                   String type,
//                                                                   String memberName,
//                                                                   String backgroundColor,
//                                                                   String textColor,
//                                                                   Boolean allDay){
//
//        PostEventRes postEventRes = PostEventRes.builder()
//                .memberIdx(memberIdx)
//                .eventIdx(eventIdx)
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
//        return postEventRes;
//    }
}
