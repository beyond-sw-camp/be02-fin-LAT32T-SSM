package com.project.ssm.calendar.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class CalendarAccessException extends BusinessException {
    public CalendarAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static CalendarAccessException forMemberId(String memberId) {
        return new CalendarAccessException(ErrorCode.MEMBER_NOT_EVENT, String.format("[%s]님이 등록한 일정이 아닙니다.", memberId));
    }
}
