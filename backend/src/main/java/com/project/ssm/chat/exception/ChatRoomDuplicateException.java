package com.project.ssm.chat.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.EntityDuplicateException;


public class ChatRoomDuplicateException extends EntityDuplicateException {

    public ChatRoomDuplicateException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ChatRoomDuplicateException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static ChatRoomDuplicateException forDuplicateChatRoom() {
        return new ChatRoomDuplicateException(ErrorCode.DUPLICATE_CHATROOM);
    }

    public static ChatRoomDuplicateException forMemberId(String memberName) {
        return new ChatRoomDuplicateException(ErrorCode.DUPLICATE_ADD_MEMBER, String.format("%s님은 이미 추가되었습니다.", memberName));
    }
}
