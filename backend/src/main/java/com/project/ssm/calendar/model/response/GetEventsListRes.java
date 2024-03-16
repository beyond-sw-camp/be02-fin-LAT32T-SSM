package com.project.ssm.calendar.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Builder
public class GetEventsListRes {

    private Long _id;
    private String title;
    private String description;
    private String start;
    private String end;
    private String type;
    private String username;
    private String backgroundColor;
    private String textColor;
    private Boolean allDay;
//    private List<GetEventRes> result;

//    private Long idx;
//    private String title;

//    private Long eventIdx;
//    private String title;
//    private String priority;
//    private String isLooped;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime startedAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime closedAt;

//    private Member member;

//    private List<Event> events;

    public static GetEventsListRes getEventsListResBuilder(Long _id, String title, String description, String start, String end, String type, String username, String backgroundColor, String textColor, Boolean allDay) {

        return GetEventsListRes.builder()
                ._id(_id)
                .title(title)
                .description(description)
                .start(start)
                .end(end)
                .type(type)
                .username(username)
                .backgroundColor(backgroundColor)
                .textColor(textColor)
                .allDay(allDay)
                .build();
    }
}
