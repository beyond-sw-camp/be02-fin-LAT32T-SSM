package com.project.ssm.sharedevents.model;

import com.project.ssm.reservation.model.MeetingReservation;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class SharedEvents {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventIdx;
    private LocalDateTime startedAt;
    private LocalDateTime closedAt;
    @ManyToOne
    @JoinColumn(name = "reservation_idx")
    private MeetingReservation reservation;
}
