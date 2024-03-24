package com.project.ssm.events.model.response;


import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class PostEventRes {

    private Long eventIdx;
    private String title;
    private String startedAt;
    private String closedAt;
    private String eventContent;
    private List<String> memberId;
    private Boolean allDay;
    private Long memberIdx;
    private String type;
    private Long meetingRoomIdx;

    public static PostEventRes buildEventRes(Event event, Member member) {

//        Long meetingRoomIdx;
//        if (event.getMeetingRoom() != null) {
//            meetingRoomIdx = event.getMeetingRoom().getMeetingRoomIdx();
//        }

        List<EventParticipants> members = event.getEventParticipantsList();
        List<String> memberIds = new ArrayList<>();
        for (int i = 0; i < members.size(); i++) {
            String memberId = event.getEventParticipantsList().get(i).getMember().getMemberId();
            memberIds.add(memberId);
        }
        return PostEventRes.builder()
                .eventIdx(event.getEventIdx())
                .memberIdx(member.getMemberIdx())
                .memberId(memberIds)
                .title(event.getTitle())
                .eventContent(event.getEventContent())
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .allDay(event.getAllDay())
                .type(event.getType())
                .meetingRoomIdx(event.getMeetingRoom().getMeetingRoomIdx())
                .build();
    }
}
