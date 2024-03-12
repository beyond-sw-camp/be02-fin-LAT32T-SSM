package com.project.ssm.calendar.model.response;


import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PostPersonalEventRes {

    private Long idx;
    private String title;
    private String priority;
    private String isLooped;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime closedAt;

    public static PostPersonalEventRes personalEventResBuilder(Long memberIdx, Long eventIdx, String title) {
        return PostPersonalEventRes.builder()
                .title(title)
                .build();
    }
}
