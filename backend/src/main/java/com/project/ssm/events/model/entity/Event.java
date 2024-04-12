package com.project.ssm.events.model.entity;

import com.project.ssm.events.model.request.PatchEventReq;
import com.project.ssm.events.model.request.PatchReservationReq;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventIdx;

    @Column(nullable = false, length = 50)
    private String title;

    @Column(nullable = false)
    private String startedAt;

    @Column(nullable = false)
    private String closedAt;

    @Column(nullable = false, length = 100)
    private String eventContent;

    @Column(nullable = true)
    private String type;

    @Column(nullable = false)
    private Long eventMaker;

    @Column(nullable = false)
    private String backgroundColor;

    @Column(nullable = false)
    private String textColor;

    @Column(nullable = false)
    private Boolean allDay;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String updatedAt;

    @OneToMany(mappedBy = "event")
    private List<EventParticipants> eventParticipantsList;

    @ManyToOne
    @JoinColumn(name = "meetingRoomIdx")
    private MeetingRoom meetingRoom;

    public static Event buildEvent(Member member, PostEventReq request, MeetingRoom meetingRoom) {
        return Event.builder()
                .meetingRoom(meetingRoom)
                .title(request.getTitle())
                .startedAt(request.getStartedAt())
                .closedAt(request.getClosedAt())
                .eventContent(request.getEventContent())
                .type(request.getType())
                .eventMaker(member.getMemberIdx())
                .backgroundColor(request.getBackgroundColor())
                .textColor(request.getTextColor())
                .allDay(request.getAllDay())
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    public static Event buildAllDayEvent(Member member, PostEventReq request, MeetingRoom meetingRoom) {
        return Event.builder()
                .meetingRoom(meetingRoom)
                .title(request.getTitle())
                .startedAt(request.getStartedAt() + " 00:00")
                .closedAt(request.getClosedAt() + " 00:00")
                .eventContent(request.getEventContent())
                .type(request.getType())
                .eventMaker(member.getMemberIdx())
                .backgroundColor(request.getBackgroundColor())
                .textColor(request.getTextColor())
                .allDay(request.getAllDay())
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }

    public static Event setEvent(PatchEventReq request, Event event) {
        event.setTitle(request.getTitle());
        event.setEventContent(request.getEventContent());
        event.setStartedAt(request.getStartedAt());
        event.setClosedAt(request.getClosedAt());
        event.setType(request.getType());
        event.setBackgroundColor(request.getBackgroundColor());
        event.setAllDay(request.getAllDay());

        return event;
    }

    public static Event setReservation (PatchReservationReq request, MeetingRoom meetingRoom, Event event) {
        event.setMeetingRoom(meetingRoom);
        event.setStartedAt(request.getReservationStart());
        event.setClosedAt(request.getReservationEnd());
        return event;
    }

}