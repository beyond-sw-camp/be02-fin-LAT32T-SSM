package com.project.ssm.meetingroom.model.response;

import com.project.ssm.events.model.entity.Event;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PostReservationRes {
    private String eventTitle;
    private Long meetingRoomIdx;

    public static PostReservationRes buildReservationRes (Event event) {
       return PostReservationRes.builder()
               .eventTitle(event.getTitle())
               .meetingRoomIdx(builder().meetingRoomIdx)
               .build();
    }
}
