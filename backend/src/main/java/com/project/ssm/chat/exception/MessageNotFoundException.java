package com.project.ssm.chat.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class MessageNotFoundException extends EntityNotFoundException {
    public MessageNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MessageNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }
    
    public static MessageNotFoundException forNotFoundMessage(Long messageIdx) {
        return new MessageNotFoundException(ErrorCode.MESSAGE_NOT_FOUND, String.format("%s번 메시지를 찾을 수 없습니다.", messageIdx));
    }
}
