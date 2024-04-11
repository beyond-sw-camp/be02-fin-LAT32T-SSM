package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class PatchReservationRes {

    @NotBlank
    @Size(max = 50)
    private String eventTitle;

    @NotBlank
    private Long meetingRoomIdx;

    public static PatchReservationRes buildReservationRes (Event event, MeetingRoom meetingRoom) {
       return PatchReservationRes.builder()
               .eventTitle(event.getTitle())
               .meetingRoomIdx(meetingRoom.getMeetingRoomIdx())
               .build();
    }
}
