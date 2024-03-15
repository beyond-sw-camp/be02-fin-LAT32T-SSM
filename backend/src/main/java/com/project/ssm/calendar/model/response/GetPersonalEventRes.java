package com.project.ssm.calendar.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;
import java.util.List;

@Setter
@Getter
@Builder
public class GetPersonalEventRes {

    private Long eventIdx;
    private String title;

    private Long memberIdx;
    private String priority;
    private String isLooped;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime closedAt;

    public static GetPersonalEventRes getPersonalEventResBuilder(Long memberIdx, Long eventIdx, String title) {
        return GetPersonalEventRes.builder()
                .memberIdx(memberIdx)
                .eventIdx(eventIdx)
                .title(title)
//                .priority(priority)
//                .isLooped(isLooped)
//                .startedAt(startedAt)
//                .closedAt(closedAt)
                .build();
    }
}
