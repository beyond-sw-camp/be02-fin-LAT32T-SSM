package com.project.ssm.chat.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class SendMessageReq {
    @NotBlank
    private String memberId;
    @NotBlank
    private String memberName;
    @NotBlank
    private String message;

    private String chatRoomId;
}
