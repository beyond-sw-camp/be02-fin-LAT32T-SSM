package com.project.ssm.events.model.response;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Builder
public class GetReservationRes {

    private Long eventIdx;
    private String eventTitle;
    private String eventStartedAt;
    private String eventClosedAt;
    private Long meetingRoomIdx;
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
