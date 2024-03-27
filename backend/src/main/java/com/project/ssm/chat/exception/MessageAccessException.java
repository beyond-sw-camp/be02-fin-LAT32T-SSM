package com.project.ssm.chat.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class MessageAccessException extends BusinessException {

    public MessageAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public MessageAccessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static MessageAccessException forNotContent() {
        return new MessageAccessException(ErrorCode.NOT_CONTENT, "메시지를 다시 입력해주세요");
    }

    public static MessageAccessException forMediaType() {
        return new MessageAccessException(ErrorCode.REJECT_MEDIA_TYPE);
    }

    public static MessageAccessException forDeleteMessage() {
        return new MessageAccessException(ErrorCode.REJECT_DELETE_MESSAGE);
    }
}
