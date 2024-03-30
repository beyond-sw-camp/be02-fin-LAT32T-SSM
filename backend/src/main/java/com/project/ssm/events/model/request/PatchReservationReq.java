package com.project.ssm.events.model.request;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Setter
@Builder
@Getter
public class PatchReservationReq {

    @NotBlank
    private Long meetingRoomIdx;

    @NotBlank
    private Long eventIdx;

    @NotBlank
    private String reservationStart;

    @NotBlank
    private String reservationEnd;
}
