package com.project.ssm.events.model.request;

import lombok.*;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Setter
@Getter
@Builder
public class PostEventReq {

    @NotBlank
    @Size(max = 50)
    private String title;   // 일정 제목

    @NotBlank
    private String startedAt;   // 일정 시작 시간

    @NotBlank
    private String closedAt;    // 일정 종료 시간

    @NotBlank
    @Size(max = 100)
    private String eventContent;    // 일정 내용

    private String type;    // 채팅방

    private List<String> memberId;  // 사용자 이름

    @NotBlank
    private String backgroundColor;

    @NotBlank
    private String textColor;

    @NotBlank
    private Boolean allDay;

    @NotBlank
    private Long meetingRoomIdx;
}
