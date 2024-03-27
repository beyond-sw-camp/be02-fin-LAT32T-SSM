package com.project.ssm.meetingroom.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class MeetingRoomNotFoundException extends EntityNotFoundException {
    public MeetingRoomNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static MeetingRoomNotFoundException forMeetingRoomIdx () {
        return new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "존재하지 않는 회의실입니다.");
    }

    public static MeetingRoomNotFoundException forMeetingRoomName (String meetingRoomName) {
        return new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, String.format("[%s]는 존재하지 않는 회의실입니다.", meetingRoomName));
    }
}
