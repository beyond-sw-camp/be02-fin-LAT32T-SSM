package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class EventDuplicateException extends EntityDuplicateException {

    public EventDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static EventDuplicateException forEventIdx(String title) {
        return new EventDuplicateException(ErrorCode.DUPLICATED_EVENT, String.format("[%s]는 이미 등록한 일정입니다.", title));
    }
}
