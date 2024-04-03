package com.project.ssm.meetingroom.model.response;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.*;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MeetingRoomListRes {

    @NotBlank
    private Long roomIdx;

    @NotBlank
    @Size(max = 20)
    private String roomName;

    @NotBlank
    @Min(value = 1) @Max(value = 10)
    private Integer roomCapacity;

    public static MeetingRoomListRes buildMeetingRoomListRes(MeetingRoom room) {
        return MeetingRoomListRes.builder()
                .roomIdx(room.getMeetingRoomIdx())
                .roomName(room.getMeetingRoomName())
                .roomCapacity(room.getMeetingRoomCapacity())
                .build();
    }
}
