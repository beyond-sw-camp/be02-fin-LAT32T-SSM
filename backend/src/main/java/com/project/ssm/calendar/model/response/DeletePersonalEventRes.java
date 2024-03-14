package com.project.ssm.calendar.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
public class DeletePersonalEventRes {
    private Long memberIdx;
    private Long eventIdx;
    private String title;

    public static DeletePersonalEventRes deletePersonalEventResBuilder (Long memberIdx, Long eventIdx, String title) {
        return DeletePersonalEventRes.builder()
                .memberIdx(memberIdx)
                .eventIdx(eventIdx)
                .title(title)
                .build();
    }
}
