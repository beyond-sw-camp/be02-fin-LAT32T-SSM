package com.project.ssm.chat.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityNotFoundException;

public class ChatRoomNotFoundException extends EntityNotFoundException {

    public ChatRoomNotFoundException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ChatRoomNotFoundException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static ChatRoomNotFoundException forNotFoundChatRoom() {
        return new ChatRoomNotFoundException(ErrorCode.CHATROOM_NOR_FOUND);
    }
}
