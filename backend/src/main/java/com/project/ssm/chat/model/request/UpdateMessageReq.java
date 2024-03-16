package com.project.ssm.chat.model.request;

import lombok.Data;

@Data
public class UpdateMessageReq {
    private String memberId;
    private String memberName;
    private Long messageIdx;
    private String message;
}
