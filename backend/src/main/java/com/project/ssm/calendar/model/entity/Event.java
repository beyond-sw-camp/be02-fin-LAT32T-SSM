package com.project.ssm.calendar.model.entity;

import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
@Setter
public class Event{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long eventIdx;
    private String title;

    private String startedAt;
    private String closedAt;

    private String eventContent;
    private String type;
    private String memberName;
    private String backgroundColor;
    private String textColor;
    private Boolean allDay;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private Member member;

}