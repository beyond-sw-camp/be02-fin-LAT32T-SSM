package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class DeleteMessageRes {
    private Long messageIdx;

    public static DeleteMessageRes buildMessageRes(Long messageIdx) {
        return DeleteMessageRes.builder().messageIdx(messageIdx).build();
    }
}
