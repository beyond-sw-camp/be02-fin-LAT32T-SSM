package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class GetRoomInfoRes {
    private String chatRoomName;

    public static GetRoomInfoRes buildDto(String roomName) {
        return GetRoomInfoRes.builder().chatRoomName(roomName).build();
    }
}
