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
public class GetChatRoomMembersRes {

    @NotBlank
    @Size(max = 20)
    private String memberName;

    public static GetChatRoomMembersRes buildReadRes(Member member) {
        return GetChatRoomMembersRes.builder()
                .memberName(member.getMemberName())
                .build();
    }
}
