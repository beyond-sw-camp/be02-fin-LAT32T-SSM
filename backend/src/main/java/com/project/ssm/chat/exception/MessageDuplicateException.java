package com.project.ssm.chat.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;

public class MessageDuplicateException extends EntityDuplicateException {

    public MessageDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MessageDuplicateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static MessageDuplicateException forDuplicateMessage(String message) {
        return new MessageDuplicateException(ErrorCode.DUPLICATE_DELETE_MESSAGE, String.format("%s 메시지는 이미 삭제되었습니다.", message));
    }
}
