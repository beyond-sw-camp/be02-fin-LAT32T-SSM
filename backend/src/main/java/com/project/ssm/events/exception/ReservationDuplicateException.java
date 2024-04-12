package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class ReservationDuplicateException extends EntityNotFoundException {
    public ReservationDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    public static ReservationDuplicateException forEvent() {
        return new ReservationDuplicateException(ErrorCode.RESERVATION_DUPLICATE, "해당 시간에 예약할 수 없습니다.");
    }
}
