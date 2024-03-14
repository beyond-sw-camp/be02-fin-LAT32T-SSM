package com.project.ssm.reservation.model;

import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.sharedevents.model.SharedEvents;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Set;


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


    @OneToMany(mappedBy = "reservation")
    private Set<SharedEvents> sharedEvents;

    private String createdAt;
    @Column(name = "started_at")
    private LocalDateTime startedAt;
    @Column(name = "closed_at")
    private LocalDateTime closedAt;
}
