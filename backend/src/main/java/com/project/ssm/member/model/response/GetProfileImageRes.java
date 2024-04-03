package com.project.ssm.member.model.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GetProfileImageRes {

    @NotBlank
    private String imageAddr;

    public static GetProfileImageRes buildProfileImage(String imageAddr) {
        return GetProfileImageRes.builder()
                .imageAddr(imageAddr)
                .build();
    }
}
