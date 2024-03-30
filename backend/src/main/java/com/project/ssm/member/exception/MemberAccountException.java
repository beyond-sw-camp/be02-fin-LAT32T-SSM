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

    public static MemberAccountException forInvalidPassword() {
        return new MemberAccountException(ErrorCode.DIFFERENT_MEMBER_PASSWORD, "비밀번호가 틀렸습니다.");
    }

    public static MemberAccountException forExpiredToken(String token) {
        return new MemberAccountException(ErrorCode.EXPIRED_VERIFICATION_TOKEN, String.format("Verification Token [ %s ] is expired.", token));
    }

    public static MemberAccountException forDifferentPassword() {
        return new MemberAccountException(ErrorCode.SAME_MEMBER_PASSWORD, "기존에 사용하던 비밀번호와 같습니다. 다른 비밀번호를 입력해주세요");
    }
}
