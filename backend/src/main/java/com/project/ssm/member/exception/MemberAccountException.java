package com.project.ssm.member.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class MemberAccountException extends BusinessException {
    public MemberAccountException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public static MemberAccountException forTokenNotExists(String token) {
        return new MemberAccountException(ErrorCode.TOKEN_NOT_EXISTS, String.format("Token [ %s ] is not exists.", token));
    }

    public static MemberAccountException forInvalidToken(String token) {
        return new MemberAccountException(ErrorCode.INVALID_VERIFICATION_TOKEN, String.format("Token [ %s ] is invalid.", token));
    }

    public static MemberAccountException forInvalidPassword(String password) {
        return new MemberAccountException(ErrorCode.DIFFERENT_USER_PASSWORD, String.format("Member Password [ %s ] is different.", password));
    }

    public static MemberAccountException forExpiredToken(String token) {
        return new MemberAccountException(ErrorCode.EXPIRED_VERIFICATION_TOKEN, String.format("Verification Token [ %s ] is expired.", token));
    }
}
