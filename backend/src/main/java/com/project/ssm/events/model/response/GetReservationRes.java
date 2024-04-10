package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Setter
@Getter
@Builder
public class GetReservationRes {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    @Size(max = 50)
    private String eventTitle;

    @NotBlank
    private String eventStartedAt;

    @NotBlank
    private String eventClosedAt;

    @NotBlank
    private Long meetingRoomIdx;

    @NotBlank
    @Size(max = 20)
    private String meetingRoomName;

    public static GetReservationRes buildReservationRes(Event event){
        return GetReservationRes.builder()
                .eventIdx(event.getEventIdx())
                .eventTitle(event.getTitle())
                .eventStartedAt(event.getStartedAt())
                .eventClosedAt(event.getClosedAt())
                .meetingRoomIdx(event.getMeetingRoom().getMeetingRoomIdx())
                .meetingRoomName(event.getMeetingRoom().getMeetingRoomName())
                .build();
    }
}
