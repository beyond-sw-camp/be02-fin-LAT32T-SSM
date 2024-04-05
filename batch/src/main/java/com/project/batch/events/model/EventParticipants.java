package com.project.batch.events.model;


import com.project.batch.member.model.Member;
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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "memberIdx")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "eventIdx")
    private Event event;

    public String getMemberId() {
        if (member != null) {
            return member.getMemberId();
        } else {
            return null;
        }
    }
}
