package com.project.ssm.search.service;

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

    public List<MemberSearchRes> searchMembers(String keyword) {
        List<Member> members = memberRepository.findByMemberNameContaining(keyword);
        List<MemberSearchRes> searchResults = new ArrayList<>();

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

        return searchResults;
    }
}
