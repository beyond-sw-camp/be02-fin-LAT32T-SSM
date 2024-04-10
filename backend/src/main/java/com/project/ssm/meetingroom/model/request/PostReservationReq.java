package com.project.ssm.meetingroom.model.request;

import lombok.Builder;
import lombok.Data;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Data
@Builder
@Setter
public class PostReservationReq {

    @NotBlank
    private Long meetingRoomIdx;

    @NotBlank
    private Long eventIdx;

    @NotBlank
    private String reservationStart;

    @NotBlank
    private String reservationEnd;
}
