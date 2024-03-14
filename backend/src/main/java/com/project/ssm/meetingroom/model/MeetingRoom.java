package com.project.ssm.meetingroom.model;

import com.project.ssm.reservation.model.MeetingReservation;
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
    private String roomName;
    private Integer roomNum;
    private Integer roomCapacity;

    @OneToMany(mappedBy = "meetingRoom")
    private List<MeetingReservation> reservations;
}
