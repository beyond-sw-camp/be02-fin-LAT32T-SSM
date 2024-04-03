package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
public class GetRoomListRes {
    @NotBlank
    private String chatRoomId;

    @NotBlank
    @Size(max = 50)
    private String chatRoomName;

    public static GetRoomListRes buildDto(String roomId, String roomName) {
        return GetRoomListRes.builder()
                .chatRoomId(roomId)
                .chatRoomName(roomName)
                .build();
    }
}
