package com.project.ssm.member.model.response;

import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.model.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PostMemberLoginRes {

    @NotBlank
    private String token;

    public static PostMemberLoginRes buildLoginRes(Member member, String secretKey, Long expiredTimeMs) {
        return PostMemberLoginRes.builder()
                .token(JwtUtils.generateAccessToken(member, secretKey, expiredTimeMs))
                .build();
    }
}
