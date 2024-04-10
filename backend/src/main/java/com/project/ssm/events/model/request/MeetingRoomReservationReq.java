package com.project.ssm.events.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRoomReservationReq {

    @NotBlank
    private Long meetingRoomIdx;

    private List<String> memberNames;
    private List<MeetingRoomReqMemberRequest> members;

    @NotBlank
    private String startedAt;

    @NotBlank
    private String closedAt;
}
