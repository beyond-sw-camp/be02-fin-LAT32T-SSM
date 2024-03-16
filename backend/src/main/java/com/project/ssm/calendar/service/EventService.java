package com.project.ssm.calendar.service;

import com.project.ssm.calendar.model.entity.Event;
import com.project.ssm.calendar.model.request.GetEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.calendar.model.response.*;
import com.project.ssm.calendar.repository.EventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class EventService {

    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;

    @Transactional
    public BaseResponse create(Member member, PostEventReq request) {
        Event event = Event.builder()
                .member(member)
                .title(request.getTitle())
                .startedAt(request.getStartedAt())
                .closedAt(request.getClosedAt())
                .eventContent(request.getEventContent())
                .type(request.getType())
                .memberName(request.getMemberName())
                .backgroundColor(request.getBackgroundColor())
                .textColor(request.getTextColor())
                .allDay(request.getAllDay())
                .build();

        eventRepository.save(event);

        BaseResponse response = BaseResponse.builder()
                .code("CALENDAR_001")
                .isSuccess(true)
                .message("새로운 일정이 생성되었습니다.")
                .result(event)
                .build();

        return response;


        // Optional<Member> Optionalmember = memberRepository.findByMemberId(memberId);
        // Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));

//        Event Event = PostEventReq.postEventReqBuilder(
//                request.getMember(),
//                        request.getTitle(),
//                        request.getStartedAt(),
//                        request.getClosedAt(),
//                        request.getEventContent(),
//                        request.getType(),
//                        request.getMemberName(),
//                        request.getBackgroundColor(),
//                        request.getTextColor(),
//                        request.getAllDay());
//
//        eventRepository.save(Event);
//
//        return BaseResponse.BaseResponseBuilder(
//                "CALENDAR_001",
//                true,
//                "새로운 일정이 생성되었습니다.",
//                postEventResBuilder(
//                        Event.getMember().getMemberIdx(),
//                        Event.getEventIdx(),
//                        Event.getTitle(),
//                        Event.getStartedAt(),
//                        Event.getClosedAt(),
//                        Event.getEventContent(),
//                        Event.getType(),
//                        Event.getMemberName(),
//                        Event.getBackgroundColor(),
//                        Event.getTextColor(),
//                        Event.getAllDay()
//                        ));
    }

    public List<GetEventsListRes> list(Member member, int year) {

        List<Event> memberEventsList = member.getEvents();

        List<GetEventsListRes> eventsList = new ArrayList<>();

        for (Event event : memberEventsList) {
            if (event.getMember().getMemberId().equals(member.getMemberId())) {
                String startedAt = event.getStartedAt();
                String closedAt = event.getClosedAt();

                LocalDateTime startTime = LocalDateTime.parse(startedAt);
                LocalDateTime closeTime = LocalDateTime.parse(closedAt);

                if (startTime.getYear() == year || closeTime.getYear() == year) {
                    GetEventsListRes eventsListRes = GetEventsListRes.getEventsListResBuilder(
                            event.getEventIdx(),
                            event.getTitle(),
                            event.getEventContent(),
                            event.getStartedAt(),
                            event.getClosedAt(),
                            event.getType(),
                            event.getMemberName(),
                            event.getBackgroundColor(),
                            event.getTextColor(),
                            event.getAllDay()
                    );
                    eventsList.add(eventsListRes);
                }
            }
        }

        return eventsList;
    }

//        public BaseResponse read(Member member, GetEventReq request) {
//
//            Optional<Event> result = eventRepository.findById(request.getEventIdx());
//
//            if(result.isPresent()){
//                Event event = result.get();
//
//                if(event.getMember().equals(member)){
//
//                }
//            }
//
////        Member member = memberRepository.findByMemberId(request.getMemberId()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
////
////        Event Event = EventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 조회되었습니다.", GetEventRes.getEventResBuilder(member.getMemberIdx(), Event.getIdx(), Event.getTitle()));
//
//    }

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

//        for (Event event: memberEvents) {
//            LocalDateTime startedAt = event.getStartedAt();
//            LocalDateTime closedAt = event.getClosedAt();
//
//            if(startedAt.getYear()==year||closedAt.getYear()==year){
//                GetEventsListRes eventsListRes = GetEventsListRes.getEventsListResBuilder(event.getIdx(), event.getTitle(), event.getStartedAt(), event.getClosedAt());
//                yearEvents.add(eventsListRes);
//            }
//        }
//
//        return response;

//    @Transactional
//    public GetEventsListRes eventslist() {
//        List<GetEventRes> result =
//

//    public BaseResponse findByYear(int year, String memberId) {
//
//        Member member = memberRepository.findByMemberId(memberId).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        List<Event> memberEvents = member.getEvents();
//
//        for (Event event: memberEvents) {
////            LocalDateTime startedAt = event.getStartedAt();
////            LocalDateTime closedAt = event.getClosedAt();
//
////            if(startedAt.getYear()==year||closedAt.getYear()==year){
////                GetEventsListRes eventsListRes = GetEventsListRes.getEventsListResBuilder(event.getIdx(), event.getTitle(), event.getStartedAt(), event.getClosedAt());
////                yearEvents.add(eventsListRes);
////            }
//        }
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 조회되었습니다.", GetEventsRes.getEventResBuilder(member.getMemberIdx(), yearEvents));
//
//    }
//
//    public BaseResponse findByEventIdx(GetEventReq request) {
//
//        Member member = memberRepository.findByMemberId(request.getMemberId()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        Event Event = EventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 조회되었습니다.", GetEventRes.getEventResBuilder(member.getMemberIdx(), Event.getIdx(), Event.getTitle()));
//
//    }
//
//    public BaseResponse updateEvent(PatchEventReq request) {
//
//        Member member = memberRepository.findById(request.getMemberIdx()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        Event Event = EventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
////        Event.setPriority(request.getPriority());
//        Event.setTitle(request.getTitle());
////        Event.setIsLooped(request.getIsLooped());
////        Event.setStartedAt(request.getStartedAt());
////        Event.setClosedAt(request.getClosedAt());
//
//        EventRepository.save(Event);
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 수정되었습니다.", PatchEventRes.patchEventResBuilder(member.getMemberIdx(), Event.getIdx(), Event.getTitle()));
//    }
//
//    public BaseResponse deleteEvent(DeleteEventReq request) {
//
//        Member member = memberRepository.findById(request.getMemberIdx()).orElseThrow(() -> new IllegalArgumentException("없는 회원입니다."));
//
//        Event Event = EventRepository.findById(request.getEventIdx()).orElseThrow(() -> new IllegalArgumentException("없는 일정입니다."));
//
//        EventRepository.deleteById(request.getEventIdx());
//
//        return BaseResponse.BaseResponseBuilder("CALENDAR_010", true, "일정이 삭제되었습니다.", DeleteEventRes.deleteEventResBuilder(member.getMemberIdx(), Event.getIdx(), Event.getTitle()));
//    }
}
