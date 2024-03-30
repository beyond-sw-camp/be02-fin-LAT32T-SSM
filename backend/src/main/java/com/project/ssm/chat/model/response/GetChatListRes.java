package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Setter
@Getter
public class GetChatListRes {
    @NotBlank
    private String message;

    @NotBlank
    private String createdAt;

    @NotBlank
    @Size(max = 45)
    private String memberName;


    public static GetChatListRes buildChatList(String message, String createdAt, String memberName) {
        return GetChatListRes.builder()
                .message(message)
                .createdAt(createdAt)
                .memberName(memberName)
                .build();
    }
}
