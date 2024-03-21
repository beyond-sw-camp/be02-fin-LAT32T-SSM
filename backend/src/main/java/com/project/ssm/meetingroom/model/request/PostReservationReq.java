package com.project.ssm.meetingroom.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

@Data
@Builder
@Setter
public class PostReservationReq {
    private Long meetingRoomIdx;
    private Long eventIdx;

    private String reservationStart;
    private String reservationEnd;
}
