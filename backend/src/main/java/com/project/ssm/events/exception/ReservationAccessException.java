package com.project.ssm.events.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class ReservationAccessException extends EntityNotFoundException {
    public ReservationAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
    public static ReservationAccessException forMemberAmount(Integer memberAmount) {
        return new ReservationAccessException(ErrorCode.RESERVATION_ACCESS, String.format("회의실의 인원은 $d명을 초과할 수 없습니다.", memberAmount));
    }
    public static ReservationAccessException forReservationTime() {
        return new ReservationAccessException(ErrorCode.RESERVATION_ACCESS, "종료 시간은 시작시간보다 앞설 수 없습니다.");
    }
}
