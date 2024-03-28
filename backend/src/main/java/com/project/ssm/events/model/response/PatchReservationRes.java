package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatchReservationRes {
    private String eventTitle;
    private Long meetingRoomIdx;

    public static PatchReservationRes buildReservationRes (Event event) {
       return PatchReservationRes.builder()
               .eventTitle(event.getTitle())
               .meetingRoomIdx(builder().meetingRoomIdx)
               .build();
    }
}
