package com.project.ssm.common.error.exception;


import com.project.ssm.common.error.ErrorCode;

public class EntityDuplicateException extends BusinessException{

    public EntityDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }
}
