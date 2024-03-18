package com.project.ssm.events.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class EventAccessException extends BusinessException {
    public EventAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static EventAccessException forMemberId(String memberId) {
        return new EventAccessException(ErrorCode.MEMBER_NOT_EVENT, String.format("[%s]님이 등록한 일정이 아닙니다.", memberId));
    }
}
