package com.project.ssm.member.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class MemberAccountException extends BusinessException {
    public MemberAccountException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MemberAccountException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static MemberAccountException forTokenNotExists() {
        return new MemberAccountException(ErrorCode.TOKEN_NOT_EXISTS, "토큰이 존재하지 않습니다. 로그인을 먼저 진행해주세요.");
    }

    public static MemberAccountException forInvalidToken() {
        return new MemberAccountException(ErrorCode.INVALID_VERIFICATION_TOKEN, "유효하지 않는 토큰입니다. 다시 로그인해주세요.");
    }

    public static MemberAccountException forInvalidPassword() {
        return new MemberAccountException(ErrorCode.DIFFERENT_MEMBER_PASSWORD, "비밀번호가 틀렸습니다.");
    }

    public static MemberAccountException forExpiredToken() {
        return new MemberAccountException(ErrorCode.EXPIRED_VERIFICATION_TOKEN, "토큰이 만료되었습니다. 다시 로그인 해주세요.");
    }

    public static MemberAccountException forDifferentPassword() {
        return new MemberAccountException(ErrorCode.SAME_MEMBER_PASSWORD, "기존에 사용하던 비밀번호와 같습니다. 다른 비밀번호를 입력해주세요.");
    }
}
