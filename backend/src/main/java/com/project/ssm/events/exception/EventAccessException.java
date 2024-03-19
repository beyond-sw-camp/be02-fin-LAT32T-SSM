package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class EventAccessException extends BusinessException {
    public EventAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public EventAccessException(ErrorCode errorCode) {
        super(errorCode);
    }

    // 승인되지 않은 사용자가 일정 등록 시도할때
    public static EventAccessException forMemberId(String memberId) {
        return new EventAccessException(ErrorCode.UNAUTHORIZED_ACCESS_EVENT, String.format("[%s]님이 등록한 일정이 아닙니다.", memberId));
    }

    // 입력할 수 없는 시간을 입력했을때
    public static EventAccessException forInvalidDateTime() {
        return new EventAccessException(ErrorCode.INVALID_DATETIME);
    }

    // 필수 입력값을 입력하지 않았들때
    public static EventAccessException forEmptyInput() {
        return  new EventAccessException(ErrorCode.EMPTY_INPUT);
    }
}
