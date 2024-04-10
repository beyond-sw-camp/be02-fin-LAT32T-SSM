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
public class PostMeetingRoomRes {

    @NotBlank
    private Long meetingRoomIdx;

    @NotBlank
    @Size(max = 20)
    private String meetingRoomName;

    @NotBlank
    @Min(value = 1) @Max(value = 10)
    private Integer meetingRoomCapacity;

    @NotBlank
    private Boolean isAvailable;

    @NotBlank
    private String createdAt;

    @NotBlank
    private String updatedAt;

    public static PostMeetingRoomRes buildMeetingRoomRes (MeetingRoom meetingRoom){
        return PostMeetingRoomRes.builder()
                .meetingRoomIdx(meetingRoom.getMeetingRoomIdx())
                .meetingRoomName(meetingRoom.getMeetingRoomName())
                .meetingRoomCapacity(meetingRoom.getMeetingRoomCapacity())
                .isAvailable(meetingRoom.getIsAvailable())
                .createdAt(meetingRoom.getCreatedAt())
                .updatedAt(meetingRoom.getUpdatedAt())
                .build();
    }
}
