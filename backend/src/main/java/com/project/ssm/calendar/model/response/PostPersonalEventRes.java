package com.project.ssm.calendar.model.response;


import com.project.ssm.member.model.Member;
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

    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime closedAt;

    private Member member;

    public static PostPersonalEventRes personalEventResBuilder(Long memberIdx, Long eventIdx, String title) {
        return PostPersonalEventRes.builder()
                .title(title)
                .member(Member.builder().memberIdx(memberIdx).build())
                .idx(eventIdx)
                .build();
    }
}
