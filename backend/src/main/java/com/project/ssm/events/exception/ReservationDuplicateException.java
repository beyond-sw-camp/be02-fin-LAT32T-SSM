package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class ReservationDuplicateException extends EntityNotFoundException {
    public ReservationDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    public ReservationDuplicateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static ReservationDuplicateException eventId(Long eventIdx) {
        return new ReservationDuplicateException(ErrorCode.RESERVATION_DUPLICATE);
    }

}
