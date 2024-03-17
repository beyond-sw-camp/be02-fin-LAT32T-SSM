package com.project.ssm.chat.model.request;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UpdateMessageReq {
    @NotBlank
    @Size(max = 45)
    private String memberId;
    @NotBlank
    @Size(max = 45)
    private String memberName;
    @NotBlank
    private Long messageIdx;
    @NotBlank
    private String message;
}
