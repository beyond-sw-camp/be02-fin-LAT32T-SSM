package com.project.ssm.events.model.response;

import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DeleteReservationCancelRes {
    private Long roomIdx;
    private String roomName;
    private Integer roomCapacity;
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

