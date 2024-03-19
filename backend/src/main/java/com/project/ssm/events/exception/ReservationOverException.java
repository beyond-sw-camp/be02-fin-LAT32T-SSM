package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class ReservationOverException extends EntityNotFoundException {
    public ReservationOverException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    public static ReservationOverException eventId(Long eventIdx) {
        return new ReservationOverException(ErrorCode.RESERVATION_OVER, "인원이 초과 되었습니다.");
    }
}
