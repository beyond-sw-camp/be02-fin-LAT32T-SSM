package com.project.ssm.calendar.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeleteEventRes {
    private Long memberIdx;
    private Long eventIdx;
    private String title;

    public static DeleteEventRes deleteEventResBuilder (Long memberIdx, Long eventIdx, String title) {
        return DeleteEventRes.builder()
                .memberIdx(memberIdx)
                .eventIdx(eventIdx)
                .title(title)
                .build();
    }
}
