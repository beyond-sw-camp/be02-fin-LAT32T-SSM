package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class EventNotFoundException extends EntityNotFoundException {
    public EventNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static EventNotFoundException forEventId(Long eventIdx) {
        return new EventNotFoundException(ErrorCode.EVENT_NOT_FOUND, String.format("%d번 일정을 찾을 수 없습니다.", eventIdx) );
    }

    public static EventNotFoundException forNoSearch(int year) {
        return new EventNotFoundException(ErrorCode.NO_SEARCH_RESULT, String.format("[%d]년의 일정을 검색할 수 없습니다.", year));
    }
}
