package com.project.ssm.reservation.model;

import com.project.ssm.meetingroom.model.MeetingRoom;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingReservation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long reservationIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetingRoom_idx")
    private MeetingRoom meetingRoom;


    private String createdAt;
    private LocalDateTime updatedAt;
}
