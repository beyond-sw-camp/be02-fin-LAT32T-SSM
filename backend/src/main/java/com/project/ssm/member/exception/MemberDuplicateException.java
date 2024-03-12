package com.project.ssm.member.exception;


import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class MemberDuplicateException extends EntityDuplicateException {

    public MemberDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    // 이메일 중복
    public static MemberDuplicateException forMemberId(String memberId) {
        return new MemberDuplicateException(ErrorCode.DUPLICATE_SIGNUP_ID, String.format("SignUp Id [ %s ] is duplicated.", memberId));
    }



}
