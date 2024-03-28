package com.project.ssm.meetingroom.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@Builder
public class MeetingRoomAddResult {

    @NotBlank
    private Long idx;

    @NotBlank
    private String roomName;
}