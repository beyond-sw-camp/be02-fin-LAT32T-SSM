package com.project.ssm.calendar.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class CalendarDuplicateException extends EntityDuplicateException {

    public CalendarDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static CalendarDuplicateException forEventIdx(String title) {
        return new CalendarDuplicateException(ErrorCode.DUPLICATED_EVENT, String.format("[%s]는 이미 등록한 일정입니다.", title));
    }




}
