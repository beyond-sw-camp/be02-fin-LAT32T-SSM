package com.project.ssm.member.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetMemberReadRes {
    private String memberId;
    private String memberName;
    private String department;
    private String position;
}
