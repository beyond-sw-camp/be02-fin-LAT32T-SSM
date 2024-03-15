package com.project.ssm.calendar.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class PatchPersonalEventRes {

    private Long memberIdx;
    private Long eventIdx;
    private String title;
    private String priority;
    private String isLooped;

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime closedAt;

    public static PatchPersonalEventRes patchPersonalEventResBuilder(Long memberIdx, Long eventIdx, String title, String priority, String isLooped, LocalDateTime startedAt, LocalDateTime closedAt) {
        return PatchPersonalEventRes.builder()
                .memberIdx(memberIdx)
                .eventIdx(eventIdx)
                .title(title)
                .priority(priority)
                .isLooped(isLooped)
                .startedAt(startedAt)
                .closedAt(closedAt)
                .build();
    }
}
