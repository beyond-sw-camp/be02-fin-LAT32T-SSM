package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Builder
@Getter
@Setter
public class ReturnMessageRes {
    @NotBlank
    @Size(max = 45)
    private String memberName;

    @NotBlank
    private String message;

    @NotBlank
    private String createdAt;

    public static ReturnMessageRes buildMessage(String memberName, String message, String createdAt) {
        return ReturnMessageRes.builder()
                .memberName(memberName)
                .message(message)
                .createdAt(createdAt)
                .build();
    }
}
