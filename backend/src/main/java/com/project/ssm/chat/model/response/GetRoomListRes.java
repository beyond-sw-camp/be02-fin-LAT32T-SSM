package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class GetRoomListRes {
    private String chatRoomId;
    private String chatRoomName;

    public static GetRoomListRes buildDto(String roomId, String roomName) {
        return GetRoomListRes.builder()
                .chatRoomId(roomId)
                .chatRoomName(roomName)
                .build();
    }
}
