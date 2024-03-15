package com.project.ssm.event.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class MeetingRoomReservationReq {
    private Long meetingRoomIdx;
    private List<MemberRequest> members;
    private LocalDateTime startedAt;
    private LocalDateTime closedAt;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MemberRequest {
        private String memberName;
    }
}
