package com.project.ssm.calendar.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class CalendarAccessException extends BusinessException {
    public CalendarAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    public CalendarAccessException(ErrorCode errorCode) {
        super(errorCode);
    }

    // 승인되지 않은 사용자가 일정 등록 시도할때
    public static CalendarAccessException forMemberId(String memberId) {
        return new CalendarAccessException(ErrorCode.UNAUTHORIZED_ACCESS_EVENT, String.format("[%s]님이 등록한 일정이 아닙니다.", memberId));
    }

    // 입력할 수 없는 시간을 입력했을때
    public static CalendarAccessException forInvalidDateTime() {
        return new CalendarAccessException(ErrorCode.INVALID_DATETIME);
    }

    // 필수 입력값을 입력하지 않았들때
    public static CalendarAccessException forEmptyInput() {
        return  new CalendarAccessException(ErrorCode.EMPTY_INPUT);
    }
}
