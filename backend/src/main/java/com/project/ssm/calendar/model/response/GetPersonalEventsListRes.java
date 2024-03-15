package com.project.ssm.calendar.model.response;

import com.project.ssm.calendar.model.entity.PersonalEvent;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class GetPersonalEventsListRes {

//    private Long idx;
//    private String title;

    private Long eventIdx;
    private String title;
//    private String priority;
//    private String isLooped;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime closedAt;

//    private Member member;

//    private List<PersonalEvent> events;

    public static GetPersonalEventsListRes getPersonalEventsListResBuilder(Long eventIdx, String title, LocalDateTime startedAt, LocalDateTime closedAt) {

        return GetPersonalEventsListRes.builder()
                .eventIdx(eventIdx)
                .title(title)
                .startedAt(startedAt)
                .closedAt(closedAt)
                .build();
    }
}
