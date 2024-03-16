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

//    private LocalDateTime startedAt;
//    private LocalDateTime closedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "memberIdx")
    private Member member;

//    public Event(Member member) {
//        this.member = member;
//        member.getEvents().add(this);
//    }

//    public static Event EventBuilder (Long eventIdx, String title,
//                                                      String startedAt,
//                                                      String closedAt,
//                                                      String eventContent,
//                                                      String type,
//                                                      String memberName,
//                                                      String backgroundColor,
//                                                      String textColor,
//                                                      Boolean allDay) {
//        return Event.builder()
//                .eventIdx(eventIdx)
//                .title(title)
//                .startedAt(startedAt)
//                .closedAt(closedAt)
//                .eventContent(eventContent)
//                .type(type)
//                .memberName(memberName)
//                .backgroundColor(backgroundColor)
//                .textColor(textColor)
//                .allDay(allDay)
//                .build();
//    }

}