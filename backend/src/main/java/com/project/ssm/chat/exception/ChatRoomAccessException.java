package com.project.ssm.chat.exception;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.common.error.exception.BusinessException;

public class ChatRoomAccessException extends BusinessException {

    public ChatRoomAccessException(ErrorCode errorCode, String message) {
        super(errorCode, message);
    }

    public ChatRoomAccessException(ErrorCode errorCode) {
        super(errorCode);
    }

    public static ChatRoomAccessException forDeleteChatRoom() {
        return new ChatRoomAccessException(ErrorCode.ALREADY_DELETE_CHATROOM);
    }

    public static ChatRoomAccessException forOutedChatRoom(String memberName) {
        return new ChatRoomAccessException(ErrorCode.ALREADY_OUTED_CHATROOM, String.format("[%s]님은 이미 채팅방에서 삭제되었습니다.", memberName));
    }

    public static ChatRoomAccessException forNotAccessChatRoom(String memberName) {
        return new ChatRoomAccessException(ErrorCode.NOT_ACCESS_CHATROOM, String.format("[%s]님은 채팅방에 존재하지 않는 사용자입니다.", memberName));
    }
}
