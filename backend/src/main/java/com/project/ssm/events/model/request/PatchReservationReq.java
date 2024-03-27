package com.project.ssm.events.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Builder
@Getter
public class PatchReservationReq {

    private Long meetingRoomIdx;
    private Long eventIdx;

    private String reservationStart;
    private String reservationEnd;
}
