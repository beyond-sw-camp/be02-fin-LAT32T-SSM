package com.project.ssm.calendar.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class CalendarDuplicateException extends EntityDuplicateException {

    public CalendarDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }



}
