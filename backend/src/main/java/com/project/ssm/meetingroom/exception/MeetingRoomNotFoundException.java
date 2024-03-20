package com.project.ssm.meetingroom.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class MeetingRoomNotFoundException extends EntityNotFoundException {
    public MeetingRoomNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static MeetingRoomNotFoundException forEventId(Long eventIdx) {
        return new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "회의실을 찾을 수 없습니다.");
    }
}
