package com.project.ssm.member.service;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.request.PostSignupReq;
import com.project.ssm.member.model.response.PostSignupRes;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MemberService {
    private final MemberRepository memberRepository;

    public BaseResponse signup(PostSignupReq req) {
        Member member = memberRepository.save(Member.builder()
                .memberId(req.getMemberId())
                .memberPw(req.getPassword())
                .memberName(req.getName())
                .department(req.getDepartment())
                .position(req.getPosition())
                .status(true)
                .startedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .build());

        return BaseResponse.builder()
                .isSuccess(true)
                .code("MEMBER_001")
                .message("회원이 등록되었습니다.")
                .result(PostSignupRes.builder()
                        .memberIdx(member.getMemberIdx())
                        .name(member.getMemberName())
                        .memberId(member.getMemberId())
                        .build())
                .build();
    }
}
