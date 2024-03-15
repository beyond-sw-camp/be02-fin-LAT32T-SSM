package com.project.ssm.event.model;

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
public class Events {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "meetingRoom_idx")
    private MeetingRoom meetingRoom;

    private String eventTitle;
    private String eventContent;

    private LocalDateTime startedAt;
    private LocalDateTime closedAt;

    private String eventColor;

    private String createdAt;
    private LocalDateTime updatedAt;
}
