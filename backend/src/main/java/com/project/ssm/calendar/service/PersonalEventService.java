package com.project.ssm.calendar.service;

import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.calendar.model.request.PostPersonalEventReq;
import com.project.ssm.calendar.model.response.PostPersonalEventRes;
import com.project.ssm.calendar.repository.PersonalEventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.response.PostMemberSignupRes;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonalEventService {

    private final PersonalEventRepository personalEventRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BaseResponse create(PostPersonalEventReq request, String memberId) {

        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

        // to Entity
        PersonalEvent personalEvent = request.personalEventReqBuilder(member);

        personalEventRepository.save(personalEvent);

        return BaseResponse.builder()
                .isSuccess(true)
                .code("CALENDAR_001")
                .message("새로운 일정이 생성되었습니다.")
                .build();
//                .result(PostPersonalEventRes.personalEventResBuilder(member.getMemberIdx(), personalEvent.getIdx(), personalEvent.getTitle())
    }
}
