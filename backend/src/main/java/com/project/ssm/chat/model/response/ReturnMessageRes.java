package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class ReturnMessageRes {
    private String memberName;
    private String message;
    private String createdAt;

    public static ReturnMessageRes buildMessage(String memberName, String message, String createdAt) {
        return ReturnMessageRes.builder()
                .memberName(memberName)
                .message(message)
                .createdAt(createdAt)
                .build();
    }
}
