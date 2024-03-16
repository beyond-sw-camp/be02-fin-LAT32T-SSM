package com.project.ssm.meetingroom.model;

import com.project.ssm.event.model.Events;
import lombok.*;

import javax.persistence.*;
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

    @OneToMany(mappedBy = "meetingRoom")
    private List<Events> events;
}
