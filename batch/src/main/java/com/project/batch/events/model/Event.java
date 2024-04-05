package com.project.batch.events.model;

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

}
