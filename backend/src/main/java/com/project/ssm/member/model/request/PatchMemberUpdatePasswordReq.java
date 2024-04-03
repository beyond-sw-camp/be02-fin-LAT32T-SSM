package com.project.ssm.member.model.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PatchMemberUpdatePasswordReq {

    @NotBlank
    @Size(max = 200)
    private String password;

    @NotBlank
    @Size(max = 200)
    private String newPassword;
}
