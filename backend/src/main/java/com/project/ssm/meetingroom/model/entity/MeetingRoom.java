package com.project.ssm.meetingroom.model.entity;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.meetingroom.model.request.PostMeetingRoomReq;
import com.project.ssm.meetingroom.model.request.PostReservationReq;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long meetingRoomIdx;

    private String meetingRoomName;
    private Integer meetingRoomCapacity;
    private Boolean isAvailable;     // true(0)이면 공실, false(1)이면 사용중

    @OneToMany(mappedBy = "meetingRoom")
    private List<Event> events;

    private String createdAt;
    private String updatedAt;

    public static MeetingRoom buildMeetingRoom (PostMeetingRoomReq request){
        return MeetingRoom.builder()
                .meetingRoomName(request.getMeetingRoomName())
                .meetingRoomCapacity(request.getMeetingRoomCapacity())
                .isAvailable(true)
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();
    }
}
