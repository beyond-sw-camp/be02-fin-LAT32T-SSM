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

    private Long memberIdx;

    public static PostPersonalEventRes postPersonalEventResBuilder(Long memberIdx, Long eventIdx, String title) {
        return PostPersonalEventRes.builder()
                .memberIdx(memberIdx)
                .title(title)
                .idx(eventIdx)
                .build();
    }
}
