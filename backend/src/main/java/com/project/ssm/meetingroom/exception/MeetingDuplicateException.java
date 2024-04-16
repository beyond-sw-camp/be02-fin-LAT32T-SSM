package com.project.ssm.meetingroom.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class MeetingDuplicateException extends EntityDuplicateException {
    public MeetingDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static MeetingDuplicateException forMeetingRoomName(String meetingRoomName) {
        return new MeetingDuplicateException(ErrorCode.MEETINGROOM_DUPLOCATE, String.format("$s는 이미 있는 회의실입니다.", meetingRoomName));
    }
}
