package com.project.ssm.chat.model.request;

import lombok.Data;

@Data
public class SendMessageReq {
    private String memberId;
    private String memberName;
    private String message;
}
