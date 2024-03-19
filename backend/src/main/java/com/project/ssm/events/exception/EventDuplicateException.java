package com.project.ssm.events.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class EventDuplicateException extends EntityDuplicateException {

    public EventDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }



}
