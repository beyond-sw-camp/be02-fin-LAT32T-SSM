package com.project.ssm.sharedevents.model;

import com.project.ssm.meetingroom.model.MeetingRoom;
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

    @ManyToOne
    @JoinColumn(name = "reservation_idx")
    private MeetingReservation reservation;
//    @ManyToOne                                 추후 필요
//    @JoinColumn(name = "chat_room_idx")
//    private ChatRoom chatRoom;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetingRoom_idx")
    private MeetingRoom meetingRoom;
    private LocalDateTime startedAt;
    private LocalDateTime closedAt;

    private String eventTitle;
    private String priority;
    private boolean isLooped;


}
