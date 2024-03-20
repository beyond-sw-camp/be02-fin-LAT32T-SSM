package com.project.ssm.events.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomReservationResResult {
    private Long eventIdx;
    private String roomName;
}
