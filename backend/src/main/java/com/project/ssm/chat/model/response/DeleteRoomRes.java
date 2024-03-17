package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;

@Builder
@Getter
@Setter
public class DeleteRoomRes {
    @NotBlank
    private String chatRoomId;
    private String updatedAt;

    public static DeleteRoomRes buildDeleteRoom(String chatRoomId, String updatedAt) {
        return DeleteRoomRes.builder()
                .chatRoomId(chatRoomId)
                .updatedAt(updatedAt)
                .build();
    }
}
