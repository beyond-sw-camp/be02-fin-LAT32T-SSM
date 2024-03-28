package com.project.ssm.events.model.response;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomReservationResResult {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    @Size(max = 20)
    private String roomName;
}
