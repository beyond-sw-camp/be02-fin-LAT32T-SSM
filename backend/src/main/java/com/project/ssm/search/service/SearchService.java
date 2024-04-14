package com.project.ssm.search.service;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import com.project.ssm.search.model.response.MemberSearchRes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final MemberRepository memberRepository;

    public BaseResponse<List<MemberSearchRes>> searchMembers(String keyword) {
        List<Member> members = memberRepository.findByMemberNameContaining(keyword);
        List<MemberSearchRes> searchResults = new ArrayList<>();

        if (members.isEmpty()) {
            return BaseResponse.successRes("SEARCH_002", false, "검색 결과가 없습니다." , searchResults);
        } else {
            for (Member member : members) {
                MemberSearchRes searchRes = MemberSearchRes.builder()
                        .memberIdx(member.getMemberIdx())
                        .memberId(member.getMemberId())
                        .memberName(member.getMemberName())
                        .position(member.getPosition())
                        .department(member.getDepartment())
                        .build();
                searchResults.add(searchRes);
            }
        }

        return BaseResponse.successRes("SEARCH_001", true, "회원 이름조회가 성공했습니다.", searchResults);
    }
}
