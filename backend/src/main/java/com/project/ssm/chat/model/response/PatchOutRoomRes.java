package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PatchOutRoomRes {
    private String chatRoomId;
    private String memberId;

    public static PatchOutRoomRes buildOutRoom(String chatRoomId, String memberId) {
        return PatchOutRoomRes.builder()
                .chatRoomId(chatRoomId)
                .memberId(memberId)
                .build();
    }
}
