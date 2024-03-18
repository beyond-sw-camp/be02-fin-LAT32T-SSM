package com.project.ssm.calendar.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;
import com.project.ssm.member.exception.MemberNotFoundException;

public class CalendarNotFoundException extends EntityNotFoundException {
    public CalendarNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static CalendarNotFoundException forEventId(Long eventIdx) {
        return new CalendarNotFoundException(ErrorCode.EVENT_NOT_FOUND, "일정을 찾을 수 없습니다.");
    }

    public static CalendarNotFoundException forNoSearch(int year) {
        return new CalendarNotFoundException(ErrorCode.NO_SEARCH_RESULT, String.format("[%d]년의 일정을 검색할 수 없습니다.", year));
    }
}
