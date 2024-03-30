package com.project.ssm.meetingroom.model.request;

import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@Builder
public class MeetingRoomAddReq {

    @NotBlank
    @Size(max = 20)
    private String roomName;

    @NotBlank
    @Min(value = 1) @Max(value = 10)
    private Integer roomCapacity;
}
