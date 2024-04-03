package com.project.ssm.events.model.response;


import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Builder
public class PostEventRes {

    @NotBlank
    private Long eventIdx;

    @NotBlank
    @Size(max = 50)
    private String title;

    @NotBlank
    private String startedAt;

    @NotBlank
    private String closedAt;

    @NotBlank
    @Size(max = 100)
    private String eventContent;

    //private List<String> memberId;

    @NotBlank
    private Boolean allDay;

    //private Long memberIdx;

    @NotBlank
    private String type;

    @NotBlank
    private Long meetingRoomIdx;

    public static PostEventRes buildEventRes(Event event, Member member) {

        if (event.getMeetingRoom() != null) {
            return PostEventRes.builder()
                    .eventIdx(event.getEventIdx())
//                .memberIdx(member.getMemberIdx())
//                .memberId(memberIds)
                    .title(event.getTitle())
                    .eventContent(event.getEventContent())
                    .startedAt(event.getStartedAt())
                    .closedAt(event.getClosedAt())
                    .allDay(event.getAllDay())
                    .type(event.getType())
                    .meetingRoomIdx(event.getMeetingRoom().getMeetingRoomIdx())
                    .build();
        } else {
            return PostEventRes.builder()
                    .eventIdx(event.getEventIdx())
//                .memberIdx(member.getMemberIdx())
//                .memberId(memberIds)
                    .title(event.getTitle())
                    .eventContent(event.getEventContent())
                    .startedAt(event.getStartedAt())
                    .closedAt(event.getClosedAt())
                    .allDay(event.getAllDay())
                    .type(event.getType())
                    .meetingRoomIdx(null)
                    .build();
        }

//        List<EventParticipants> members = event.getEventParticipantsList();
//        List<String> memberIds = new ArrayList<>();
//        for (int i = 0; i < members.size(); i++) {
//            String memberId = event.getEventParticipantsList().get(i).getMember().getMemberId();
//            memberIds.add(memberId);
//        }

    }
}
