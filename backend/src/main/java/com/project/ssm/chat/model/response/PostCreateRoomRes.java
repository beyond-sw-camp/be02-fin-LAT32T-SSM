package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class PostCreateRoomRes {

    private String chatRoomName;
    private String chatRoomId;

    public static PostCreateRoomRes buildRoomRes(String chatRoomName, String chatRoomId) {
        return PostCreateRoomRes.builder()
                .chatRoomName(chatRoomName)
                .chatRoomId(chatRoomId)
                .build();
    }
}
