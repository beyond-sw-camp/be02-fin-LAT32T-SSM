package com.project.ssm.events.model.entity;


import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Table(name = "EventParticipants")
public class EventParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventIdx")
    private Event event;

    public static EventParticipants buildEventPart(Event savedEvent, Member member) {
        return EventParticipants.builder()
                .event(savedEvent)
                .member(member)
                .build();
    }
}
