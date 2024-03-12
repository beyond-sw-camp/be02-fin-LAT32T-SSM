package com.project.ssm.member.service;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.config.filter.JwtFilter;
import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.exception.MemberAccountException;
import com.project.ssm.member.exception.MemberDuplicateException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.request.PostMemberLoginReq;
import com.project.ssm.member.model.request.PostMemberSignupReq;
import com.project.ssm.member.model.response.PostMemberLoginRes;
import com.project.ssm.member.model.response.PostMemberSignupRes;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberService {

    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;

    public BaseResponse signup(PostMemberSignupReq req) {
        Optional<Member> byMemberId = memberRepository.findByMemberId(req.getMemberId());

        if (byMemberId.isPresent()) {
            throw MemberDuplicateException.forMemberId(req.getMemberId());
        }

        Member member = memberRepository.save(Member.builder()
                .memberId(req.getMemberId())
                .memberPw(passwordEncoder.encode(req.getPassword()))
                .memberName(req.getName())
                .department(req.getDepartment())
                .position(req.getPosition())
                .status(true)
                .startedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .authority("ROLE_USER")
                .build());

        return BaseResponse.builder()
                .isSuccess(true)
                .code("MEMBER_001")
                .message("회원이 등록되었습니다.")
                .result(PostMemberSignupRes.builder()
                        .memberIdx(member.getMemberIdx())
                        .name(member.getMemberName())
                        .memberId(member.getMemberId())
                        .build())
                .build();
    }

    public BaseResponse login(PostMemberLoginReq req) {
        Optional<Member> byMemberId = memberRepository.findByMemberId(req.getMemberId());

        if (byMemberId.isEmpty()) {
            throw new RuntimeException("일단 아이디 못찾아");
        }
        Member member = byMemberId.get();
        if (passwordEncoder.matches(req.getPassword(), member.getPassword()) && member.getStatus().equals(true)) {

            return BaseResponse.builder()
                    .isSuccess(true)
                    .code("MEMBER_011")
                    .message("로그인에 성공하였습니다.")
                    .result(PostMemberLoginRes.builder()
                            .token(JwtUtils.generateAccessToken(member, secretKey, expiredTimeMs))
                            .build())
                    .build();
        }else {
            throw MemberAccountException.forInvalidPassword(req.getPassword());
        }
    }
}
