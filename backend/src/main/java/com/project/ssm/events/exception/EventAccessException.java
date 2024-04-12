package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class EventAccessException extends BusinessException {
    public EventAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static EventAccessException forMemberId(String memberId) {
        return new EventAccessException(ErrorCode.UNAUTHORIZED_ACCESS_EVENT, "일정에 접근 권한이 없습니다.");
    }

}
