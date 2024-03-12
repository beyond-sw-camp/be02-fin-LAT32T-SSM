package com.project.ssm.calendar.model.request;


import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.member.model.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Setter
@Getter
@Builder
public class PostPersonalEventReq {

    private Long idx;
    private String title;
    private String priority;
    private String isLooped;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime startedAt;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime closedAt;

    public PersonalEvent personalEventReqBuilder(Member member){
        PersonalEvent personalEvent = PersonalEvent.builder()
                .title(title)
                .priority(priority)
                .isLooped(isLooped)
                .startedAt(startedAt)
                .closedAt(closedAt)
                .build();

        personalEvent.setMember(member);
        return personalEvent;
    }

}
