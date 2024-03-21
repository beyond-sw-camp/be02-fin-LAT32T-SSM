package com.project.ssm.events.model.request;

import lombok.*;

@Setter
@Getter
@Builder
public class PostEventReq {

    private String title;   // 일정 제목
    private String startedAt;   // 일정 시작 시간
    private String closedAt;    // 일정 종료 시간
    private String eventContent;    // 일정 내용
    private String type;    // 채팅방
    private String memberName;  // 사용자 이름
    private String backgroundColor;
    private String textColor;
    private Boolean allDay;
    private Long meetingRoomIdx;

}
