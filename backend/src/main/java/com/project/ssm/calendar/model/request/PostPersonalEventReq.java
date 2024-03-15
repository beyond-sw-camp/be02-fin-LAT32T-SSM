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

    private String title;
    private String startedAt;
    private String closedAt;

//    private String priority;
//    private String isLooped;

//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime startedAt;
//    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
//    private LocalDateTime closedAt;

    public PersonalEvent postPersonalEventReqBuilder(String title, String startedAt, String closedAt){
        PersonalEvent personalEvent = PersonalEvent.builder()
                .title(title)
//                .priority(priority)
//                .isLooped(isLooped)
                .startedAt(startedAt)
                .closedAt(closedAt)
                .build();

        return personalEvent;
    }

}
