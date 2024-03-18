package com.project.ssm.calendar.service;

import com.project.ssm.calendar.exception.CalendarAccessException;
import com.project.ssm.calendar.exception.CalendarNotFoundException;
import com.project.ssm.calendar.model.entity.Event;
import com.project.ssm.calendar.model.request.PatchEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.calendar.model.response.*;
import com.project.ssm.calendar.repository.EventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
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
        Event event = eventRepository.save(Event.buildEvent(member, request));
        PostEventRes postEventRes = PostEventRes.buidEventRes(event, member);
        return BaseResponse.builder()
                .code("CALENDAR_001")
                .isSuccess(true)
                .message("새로운 일정이 생성되었습니다.")
                .result(postEventRes)
                .build();
    }

    public Object read(Member member, Long eventIdx) {
        Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
                CalendarNotFoundException.forEventId(eventIdx));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            return GetEventRes.buildEventRes(event);
        } else {
            return CalendarAccessException.forMemberId(member.getMemberId());
        }
    }

    public List<GetEventRes> list(Member member, int year) {
        List<Event> events = eventRepository.findEventsByYear(member.getMemberIdx(), year);
        List<GetEventRes> eventsList = new ArrayList<>();
        for (Event event: events) {
            GetEventRes getEventRes = GetEventRes.buildEventRes(event);
            eventsList.add(getEventRes);
        }
        return eventsList;
    }

    public BaseResponse update(Member member, PatchEventReq request) {
        Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                CalendarNotFoundException.forEventId(request.getEventIdx()));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            Event updatedEvent = Event.setEvent(request, event);
            eventRepository.save(updatedEvent);
            PatchEventRes patchEventRes = PatchEventRes.buildEventRes(updatedEvent);
            return BaseResponse.builder()
                    .code("CALENDAR_010")
                    .isSuccess(true)
                    .message("일정이 수정되었습니다.")
                    .result(patchEventRes)
                    .build();
        } else {
            return BaseResponse.builder()
                    .code("ERROR")
                    .isSuccess(false)
                    .message("일정이 수정에 실패하였습니다.")
                    .build();
        }
    }

    public BaseResponse delete(Member member, Long eventIdx) {
        Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
                CalendarNotFoundException.forEventId(eventIdx));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            eventRepository.delete(event);
            DeleteEventRes deleteEventRes = DeleteEventRes.buildEventRes(event);
            return BaseResponse.builder()
                    .code("CALENDAR_010")
                    .isSuccess(true)
                    .message("일정이 삭제되었습니다.")
                    .result(deleteEventRes)
                    .build();
        } else {
            return BaseResponse.builder()
                    .code("ERROR")
                    .isSuccess(false)
                    .message("일정 삭제에 실패하였습니다.")
                    .build();
        }
    }

}
