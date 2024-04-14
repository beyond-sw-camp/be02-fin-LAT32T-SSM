package com.project.ssm.events.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class ReservationNotFoundException extends EntityNotFoundException {

    public ReservationNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    public static ReservationNotFoundException eventId(Long eventIdx) {
        return new ReservationNotFoundException(ErrorCode.RESERVATION_NOT_FOUND, String.format("%d번 예약을 찾을 수 없습니다.", eventIdx));
    }
}
