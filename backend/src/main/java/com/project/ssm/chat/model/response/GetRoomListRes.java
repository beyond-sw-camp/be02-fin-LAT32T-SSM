package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetRoomListRes {
    private String chatRoomId;
    private String chatRoomName;

    public static GetRoomListRes buildDto(String roomName, String roomId) {
        return GetRoomListRes.builder()
                .chatRoomId(roomId)
                .chatRoomName(roomName)
                .build();
    }
}
