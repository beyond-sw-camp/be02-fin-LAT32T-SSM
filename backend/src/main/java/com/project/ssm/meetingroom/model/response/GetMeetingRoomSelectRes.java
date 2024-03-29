package com.project.ssm.meetingroom.model.response;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Getter
@Setter
@Builder
public class GetMeetingRoomSelectRes {

    @NotBlank
    private Long roomIdx;

    @NotBlank
    @Size(max = 20)
    private String roomName;

    @NotBlank
    @Min(value = 1) @Max(value = 10)
    private Integer roomCapacity;
    private List<MeetingSelectResReservation> reservations;

    public static GetMeetingRoomSelectRes buildRoomSelectRes(MeetingRoom meetingRoom, List<MeetingSelectResReservation> reservationList) {
        return GetMeetingRoomSelectRes.builder() // 회의실 정보 저장
                .roomIdx(meetingRoom.getMeetingRoomIdx())
                .roomName(meetingRoom.getMeetingRoomName())
                .roomCapacity(meetingRoom.getMeetingRoomCapacity())
                .reservations(reservationList)                // 예약 정보
                .build();
    }
}
