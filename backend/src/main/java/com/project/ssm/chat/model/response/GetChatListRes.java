package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class GetChatListRes {

    private String message;
    private String createdAt;
    private String memberName;


    public static GetChatListRes buildChatList(String message, String createdAt, String memberName) {
        return GetChatListRes.builder()
                .message(message)
                .createdAt(createdAt)
                .memberName(memberName)
                .build();
    }
}
