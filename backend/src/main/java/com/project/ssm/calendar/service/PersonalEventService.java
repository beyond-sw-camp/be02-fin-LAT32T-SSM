package com.project.ssm.calendar.service;

import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.calendar.model.request.DeletePersonalEventReq;
import com.project.ssm.calendar.model.request.GetPersonalEventReq;
import com.project.ssm.calendar.model.request.PatchPersonalEventReq;
import com.project.ssm.calendar.model.request.PostPersonalEventReq;
import com.project.ssm.calendar.model.response.*;
import com.project.ssm.calendar.repository.PersonalEventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static com.project.ssm.calendar.model.response.PostPersonalEventRes.postPersonalEventResBuilder;

@Service
@RequiredArgsConstructor
@Transactional
public class PersonalEventService {

    private final PersonalEventRepository personalEventRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BaseResponse create(PostPersonalEventReq request) {

        // Optional<Member> Optionalmember = memberRepository.findByMemberId(memberId);
        // Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

        PersonalEvent personalEvent = request.postPersonalEventReqBuilder(request.getTitle(), request.getStartedAt(), request.getClosedAt());

        personalEventRepository.save(personalEvent);

        return BaseResponse.BaseResponseBuilder("CALENDAR_001", true, "새로운 일정이 생성되었습니다.", postPersonalEventResBuilder(personalEvent.getIdx(), personalEvent.getTitle()));

    }

//    public BaseResponse findByYear(int year, String memberId) {
//
//        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        List<PersonalEvent> memberEvents = member.getPersonalEvents();
//        List<GetPersonalEventsListRes> yearEvents = new ArrayList<>();
//
//        for (PersonalEvent event: memberEvents) {
////            LocalDateTime startedAt = event.getStartedAt();
////            LocalDateTime closedAt = event.getClosedAt();
//
////            if(startedAt.getYear()==year||closedAt.getYear()==year){
////                GetPersonalEventsListRes eventsListRes = GetPersonalEventsListRes.getPersonalEventsListResBuilder(event.getIdx(), event.getTitle(), event.getStartedAt(), event.getClosedAt());
////                yearEvents.add(eventsListRes);
////            }
//        }
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 조회되었습니다.", GetPersonalEventsRes.getPersonalEventResBuilder(member.getMemberIdx(), yearEvents));
//
//    }
//
//    public BaseResponse findByEventIdx(GetPersonalEventReq request) {
//
//        Member member = memberRepository.findByMemberId(request.getMemberId()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        PersonalEvent personalEvent = personalEventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 조회되었습니다.", GetPersonalEventRes.getPersonalEventResBuilder(member.getMemberIdx(), personalEvent.getIdx(), personalEvent.getTitle()));
//
//    }
//
//    public BaseResponse updateEvent(PatchPersonalEventReq request) {
//
//        Member member = memberRepository.findById(request.getMemberIdx()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        PersonalEvent personalEvent = personalEventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
////        personalEvent.setPriority(request.getPriority());
//        personalEvent.setTitle(request.getTitle());
////        personalEvent.setIsLooped(request.getIsLooped());
////        personalEvent.setStartedAt(request.getStartedAt());
////        personalEvent.setClosedAt(request.getClosedAt());
//
//        personalEventRepository.save(personalEvent);
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 수정되었습니다.", PatchPersonalEventRes.patchPersonalEventResBuilder(member.getMemberIdx(), personalEvent.getIdx(), personalEvent.getTitle()));
//    }
//
//    public BaseResponse deleteEvent(DeletePersonalEventReq request) {
//
//        Member member = memberRepository.findById(request.getMemberIdx()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        PersonalEvent personalEvent = personalEventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
//        personalEventRepository.deleteById(request.getEventIdx());
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 삭제되었습니다.", DeletePersonalEventRes.deletePersonalEventResBuilder(member.getMemberIdx(), personalEvent.getIdx(), personalEvent.getTitle()));
//    }
}
