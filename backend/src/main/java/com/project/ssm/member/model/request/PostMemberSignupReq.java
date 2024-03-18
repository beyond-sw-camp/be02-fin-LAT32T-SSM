package com.project.ssm.member.model.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMemberSignupReq {

    private String memberId;
    private String password;
    private String memberName;
    private String department;
    private String position;
}
