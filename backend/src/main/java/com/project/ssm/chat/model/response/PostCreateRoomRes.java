package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
public class PostCreateRoomRes {
    @NotBlank
    @Size(max = 50)
    private String chatRoomName;

    @NotBlank
    private String chatRoomId;

    public static PostCreateRoomRes buildRoomRes(String chatRoomName, String chatRoomId) {
        return PostCreateRoomRes.builder()
                .chatRoomName(chatRoomName)
                .chatRoomId(chatRoomId)
                .build();
    }
}
