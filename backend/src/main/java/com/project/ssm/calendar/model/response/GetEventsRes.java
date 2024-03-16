package com.project.ssm.calendar.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class GetEventsRes {

//    private Long idx;
//    private String title;

    private Long memberIdx;
//    private String priority;
//    private String isLooped;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime startedAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime closedAt;

//    private Member member;

    private List<GetEventsListRes> events;

    public static GetEventsRes getEventResBuilder(Long memberIdx, List<GetEventsListRes> events) {
        return GetEventsRes.builder()
                .memberIdx(memberIdx)
                .events(events)
                .build();
    }
}
