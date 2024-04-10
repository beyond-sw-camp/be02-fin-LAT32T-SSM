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
public class PostMemberSignupReq {

    @NotBlank
    @Size(max = 45)
    private String memberId;

    @NotBlank
    @Size(max = 200)
    private String password;

    @NotBlank
    @Size(max = 20)
    private String memberName;

    @NotBlank
    @Size(max = 45)
    private String department;

    @NotBlank
    @Size(max = 45)
    private String position;
}
