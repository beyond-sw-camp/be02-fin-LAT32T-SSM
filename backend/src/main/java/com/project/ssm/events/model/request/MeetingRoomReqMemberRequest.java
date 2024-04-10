package com.project.ssm.events.model.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRoomReqMemberRequest {

    @NotBlank
    @Size(max = 20)
    private String memberName;
}

