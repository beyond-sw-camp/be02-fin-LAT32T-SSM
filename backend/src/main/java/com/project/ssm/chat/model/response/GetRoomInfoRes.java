package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class GetRoomInfoRes {
    private String chatRoomName;
    private List<ReturnMessageRes> messageList;

    public static GetRoomInfoRes buildDto(String roomName, List<ReturnMessageRes> messageList) {
        return GetRoomInfoRes.builder()
                .chatRoomName(roomName)
                .messageList(messageList)
                .build();
    }
}
