package com.project.ssm.meetingroom.model;

import com.project.ssm.reservation.model.MeetingReservation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
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
    private Long roomIdx;
    private String roomName;
    private Integer roomNum;
    private Integer roomCapacity;
    private Boolean roomStatus;

    @OneToMany(mappedBy = "meetingRoom")
    private List<MeetingReservation> reservations;
}
