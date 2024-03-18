package com.project.ssm.meetingroom.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class EventNotFoundException extends EntityNotFoundException {
    public EventNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static EventNotFoundException forEventId(Long eventIdx) {
        return new EventNotFoundException(ErrorCode.EVENT_NOT_FOUND, "일정을 찾을 수 없습니다.");
    }
}
