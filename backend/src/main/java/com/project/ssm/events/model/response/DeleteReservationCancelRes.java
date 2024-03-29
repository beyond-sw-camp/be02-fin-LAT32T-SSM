package com.project.ssm.events.model.response;

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
public class DeleteReservationCancelRes {

    @NotBlank
    private Long roomIdx;

    @NotBlank
    @Size(max = 20)
    private String roomName;

    @NotBlank
    @Min(value = 1) @Max(value = 10)
    private Integer roomCapacity;

    @NotBlank
    private DeleteReservationInfoRes reservations;

    public static DeleteReservationCancelRes buildReservationCancel(MeetingRoom meetingRoom, DeleteReservationInfoRes deleteReservationInfoRes) {
        return DeleteReservationCancelRes.builder()
                .roomIdx(meetingRoom.getMeetingRoomIdx())
                .roomName(meetingRoom.getMeetingRoomName())
                .roomCapacity(meetingRoom.getMeetingRoomCapacity())
                .reservations(deleteReservationInfoRes)
                .build();
    }
}

