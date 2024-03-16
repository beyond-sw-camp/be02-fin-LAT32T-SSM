package com.project.ssm.calendar.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class DeleteEventReq {
    private Long eventIdx;
    private Long memberIdx;
}
