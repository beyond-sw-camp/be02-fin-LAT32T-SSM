package com.project.ssm.calendar.model.entity;

import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class PersonalEvent{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;
    private String title;
    private String priority;
    private String isLooped;

    private LocalDateTime startedAt;
    private LocalDateTime closedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private Member member;

    public PersonalEvent(Member member) {
        this.member = member;
        member.getPersonalEvents().add(this);
    }

    public static PersonalEvent personalEventBuilder (String title, String priority, String isLooped, LocalDateTime startedAt, LocalDateTime closedAt) {
        return PersonalEvent.builder()
                .title(title)
                .priority(priority)
                .isLooped(isLooped)
                .startedAt(startedAt)
                .closedAt(closedAt)
                .build();
    }

}