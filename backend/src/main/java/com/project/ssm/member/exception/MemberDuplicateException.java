package com.project.ssm.member.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class MemberDuplicateException extends EntityDuplicateException {

    public MemberDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    // 회원ID 중복
    public static MemberDuplicateException forMemberId(String memberId) {
        return new MemberDuplicateException(ErrorCode.DUPLICATE_SIGNUP_ID, String.format("%s은 이미 존재하는 아이디입니다.", memberId));
    }

}
