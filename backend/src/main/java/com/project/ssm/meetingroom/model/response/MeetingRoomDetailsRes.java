package com.project.ssm.meetingroom.model.response;

import com.project.ssm.meetingroom.dto.ReservationDetails;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class MeetingRoomDetailsRes {
    private Long roomIdx;
    private String roomName;
    private Integer roomNumber;
    private Integer roomCapacity;
    private List<ReservationDetails> reservations;
}
