package com.project.ssm.meetingroom.model.response;

import lombok.*;

import javax.validation.constraints.NotBlank;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingSelectRes {

    @NotBlank
    private GetMeetingRoomSelectRes result;


}
