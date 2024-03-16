package com.project.ssm.calendar.service;

import com.project.ssm.calendar.model.entity.Event;
import com.project.ssm.calendar.model.request.DeleteEventReq;
import com.project.ssm.calendar.model.request.PatchEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.calendar.model.response.*;
import com.project.ssm.calendar.repository.EventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@Transactional
public class EventService {

    private final EventRepository eventRepository;

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

        PostEventRes postEventRes = PostEventRes.builder()
                .eventIdx(event.getEventIdx())
                .memberIdx(member.getMemberIdx())
                .memberName(member.getMemberName())
                .title(event.getTitle())
                .eventContent(event.getEventContent())
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .allDay(event.getAllDay())
                .build();

        BaseResponse response = BaseResponse.builder()
                .code("CALENDAR_001")
                .isSuccess(true)
                .message("새로운 일정이 생성되었습니다.")
                .result(postEventRes)
                .build();

        return response;
    }

    public GetEventRes read(Member member, Long eventIdx) {

        Optional<Event> result = eventRepository.findById(eventIdx);

        Long memberIdxOfEvent = result.get().getMember().getMemberIdx();

        if (result.isPresent()&&memberIdxOfEvent.equals(member.getMemberIdx())) {
            Event event = result.get();

            GetEventRes getEventRes = GetEventRes.builder()
                    ._id(event.getEventIdx())
                    .title(event.getTitle())
                    .description(event.getEventContent())
                    .start(event.getStartedAt())
                    .end(event.getClosedAt())
                    .type(event.getType())
                    .username(event.getMemberName())
                    .backgroundColor(event.getBackgroundColor())
                    .textColor(event.getTextColor())
                    .allDay(event.getAllDay())
                    .build();

            return getEventRes;
        } else {
            return GetEventRes.builder().build();
        }
    }

        public List<GetEventRes> list(Member member, int year) {

            List<Event> events = eventRepository.findEventsByYear(member.getMemberIdx(), year);
            List<GetEventRes> eventsList = new ArrayList<>();

            for (Event event: events) {

                GetEventRes getEventRes = GetEventRes.builder()
                        ._id(event.getEventIdx())
                        .title(event.getTitle())
                        .description(event.getEventContent())
                        .start(event.getStartedAt())
                        .end(event.getClosedAt())
                        .type(event.getType())
                        .username(event.getMemberName())
                        .backgroundColor(event.getBackgroundColor())
                        .textColor(event.getTextColor())
                        .allDay(event.getAllDay())
                        .build();

                eventsList.add(getEventRes);
            }

            return eventsList;
        }

        public BaseResponse update(Member member, PatchEventReq request) {

            Optional<Event> result = eventRepository.findById(request.getEventIdx());

            Long memberIdxOfEvent = result.get().getMember().getMemberIdx();

            if (result.isPresent() && memberIdxOfEvent.equals(member.getMemberIdx())) {
                Event event = result.get();

                event.setTitle(request.getTitle());
                event.setEventContent(request.getEventContent());
                event.setStartedAt(request.getStartedAt());
                event.setClosedAt(request.getClosedAt());
                event.setType(request.getType());
                event.setBackgroundColor(request.getBackgroundColor());
                event.setAllDay(request.getAllDay());

                eventRepository.save(event);

                PatchEventRes patchEventRes = PatchEventRes.builder()
                        .eventIdx(event.getEventIdx())
                        .title(event.getTitle())
                        .eventContent(event.getEventContent())
                        .startedAt(event.getStartedAt())
                        .closedAt(event.getClosedAt())
                        .type(event.getType())
                        .backgroundColor(event.getBackgroundColor())
                        .allDay(event.getAllDay())
                        .build();

                BaseResponse response = BaseResponse.builder()
                        .code("CALENDAR_010")
                        .isSuccess(true)
                        .message("일정이 수정되었습니다.")
                        .result(patchEventRes)
                        .build();

                return response;

            } else {

                BaseResponse response = BaseResponse.builder()
                        .code("ERROR")
                        .isSuccess(false)
                        .message("일정이 수정에 실패하였습니다.")
                        .build();

                return response;
            }
        }

    public BaseResponse delete(Member member, Long eventIdx) {

        Optional<Event> result = eventRepository.findById(eventIdx);

        Long memberIdxOfEvent = result.get().getMember().getMemberIdx();

        if (result.isPresent() && memberIdxOfEvent.equals(member.getMemberIdx())) {
            Event event = result.get();

            eventRepository.delete(event);

            DeleteEventRes deleteEventRes = DeleteEventRes.builder()
                    .eventIdx(event.getEventIdx())
                    .build();

            BaseResponse response = BaseResponse.builder()
                    .code("CALENDAR_010")
                    .isSuccess(true)
                    .message("일정이 삭제되었습니다.")
                    .result(deleteEventRes)
                    .build();

            return response;

        } else {

            BaseResponse response = BaseResponse.builder()
                    .code("ERROR")
                    .isSuccess(false)
                    .message("일정 삭제에 실패하였습니다.")
                    .build();

            return response;
        }
    }

}
