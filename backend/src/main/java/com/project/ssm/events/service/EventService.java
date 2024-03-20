package com.project.ssm.events.service;

import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.events.exception.*;
import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.request.PatchEventReq;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.events.model.response.*;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.model.request.MeetingRoomReservationReq;
import com.project.ssm.events.model.response.DeleteReservationCancelRes;
import com.project.ssm.events.model.response.DeleteReservationInfoRes;
import com.project.ssm.events.model.response.MeetingRoomReservationRes;
import com.project.ssm.events.repository.EventParticipantsRepository;
import com.project.ssm.meetingroom.exception.MeetingRoomNotFoundException;
import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.member.exception.MemberNotFoundException;
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
    private final EventParticipantsRepository eventParticipantsRepository;

    @Transactional
    public BaseResponse<PostEventRes> createEvent(Member member, PostEventReq request) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Event event = eventRepository.save(Event.buildEvent(verifiedMember, request));
        eventParticipantsRepository.save(EventParticipants.buildEventPart(event,verifiedMember));
        PostEventRes postEventRes = PostEventRes.buidEventRes(event, verifiedMember);
        return BaseResponse.successRes("EVENT_001", true, "일정이 등록되었습니다.", postEventRes);
    }

    public List<GetEventRes> listEvents(Member member, int year) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<Event> events = eventRepository.findEventsByYear(verifiedMember.getMemberIdx(), year);
        List<GetEventRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (Event event: events) {
                eventsList.add(GetEventRes.buildEventRes(verifiedMember, event));
            }
            return eventsList;
        } else {
            // 찾는 데이터가 없을 경우 예외 처리
//            for (Event event: events) {
//            }
            Long eventIdx = null;
            throw EventNotFoundException.forEventId(eventIdx);
        }
    }

    public BaseResponse<List<GetEventRes>> readEvent(Member member, String date) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<Event> events = eventRepository.findEventsByDate(verifiedMember.getMemberIdx(), date);
        List<GetEventRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (Event event: events) {
                eventsList.add(GetEventRes.buildEventRes(verifiedMember, event));
            }
            return BaseResponse.successRes("EVENT_002", true, "일정이 상세 조회되었습니다.", eventsList);
        } else {
            // 찾는 데이터가 없을 경우 예외 처리
//            for (Event event: events) {
//            }
            Long eventIdx = null;
            throw EventNotFoundException.forEventId(eventIdx);
        }
    }

    public BaseResponse<PatchEventRes> updateEvent(Member member, PatchEventReq request) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                EventNotFoundException.forEventId(request.getEventIdx()));
        Long memberIdxOfEvent = verifiedMember.getMemberIdx();
        if(memberIdxOfEvent.equals(member.getMemberIdx())){
            Event updatedEvent = eventRepository.save(Event.setEvent(request, event));
            PatchEventRes patchEventRes = PatchEventRes.buildEventRes(updatedEvent);
            return BaseResponse.successRes("EVENT_003", true, "일정이 수정되었습니다.", patchEventRes);
        }
        else throw EventAccessException.forMemberId(verifiedMember.getMemberId());
    }

    @Transactional
    public BaseResponse<DeleteEventRes> deleteEvent(Member member, Long eventIdx) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
                EventNotFoundException.forEventId(eventIdx));
        Long memberIdxOfEvent = verifiedMember.getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            eventParticipantsRepository.deleteByEvent(event);
            eventRepository.delete(event);
            DeleteEventRes deleteEventRes = DeleteEventRes.buildEventRes(event);
            return BaseResponse.successRes("EVENT_004", true, "일정이 삭제되었습니다.", deleteEventRes);
        } else {
            throw EventAccessException.forMemberId(member.getMemberId());
        }
    }
}
