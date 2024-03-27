package com.project.ssm.member.model.response;

import com.project.ssm.member.model.Member;
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
public class GetMemberReadRes {

    @NotBlank
    @Size(max = 45)
    private String memberId;

    @NotBlank
    @Size(max = 20)
    private String memberName;

    @NotBlank
    @Size(max = 45)
    private String department;

    @NotBlank
    @Size(max = 45)
    private String position;

    public static GetMemberReadRes buildReadRes(Member member) {
        return GetMemberReadRes.builder()
                .memberId(member.getMemberId())
                .memberName(member.getMemberName())
                .department(member.getDepartment())
                .position(member.getPosition())
                .build();
    }
}
