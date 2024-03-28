package com.project.ssm.events.service;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.events.config.ReservationFilter;
import com.project.ssm.events.exception.*;
import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.model.request.PatchEventReq;
import com.project.ssm.events.model.request.PatchReservationReq;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.events.model.response.*;
import com.project.ssm.events.repository.EventParticipantsRepository;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.meetingroom.exception.MeetingRoomNotFoundException;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.events.model.response.PatchReservationRes;
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
    private final MeetingRoomRepository meetingRoomRepository;
    private final ReservationFilter reservationFilter;

    @Transactional
    public BaseResponse<PostEventRes> createEvent(Member member, PostEventReq request) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        MeetingRoom meetingRoom;
        if (request.getMeetingRoomIdx() == null) {
            Event event = eventRepository.save(Event.buildEvent(verifiedMember, request, null));
            List<String> memberIds = request.getMemberId();
            for (String memberId : memberIds) {
                Member byMemberId = memberRepository.findByMemberId(memberId).orElseThrow(()->
                        MemberNotFoundException.forMemberId(memberId));
                eventParticipantsRepository.save(EventParticipants.buildEventPart(event, byMemberId));
            }
            PostEventRes postEventRes = PostEventRes.buildEventRes(event, verifiedMember);
            return BaseResponse.successRes("CALENDAR_001", true, "일정이 등록되었습니다.", postEventRes);
        } else {
            Optional<MeetingRoom> result = meetingRoomRepository.findById(request.getMeetingRoomIdx());
            if (result.isPresent()) {
                meetingRoom = result.get();
                if(reservationFilter.reservationFilter(request.getMeetingRoomIdx(), request.getStartedAt(), request.getClosedAt())){
                    Event event = eventRepository.save(Event.buildEvent(verifiedMember, request, meetingRoom));
                    List<String> memberIds = request.getMemberId();
                    for (String memberId : memberIds) {
                        Member byMemberId = memberRepository.findByMemberId(memberId).orElseThrow(()->
                                MemberNotFoundException.forMemberId(memberId));
                        eventParticipantsRepository.save(EventParticipants.buildEventPart(event, byMemberId));
                    }
                    PostEventRes postEventRes = PostEventRes.buildEventRes(event, verifiedMember);
                    return BaseResponse.successRes("CALENDAR_001", true, "일정이 등록되었습니다.", postEventRes);
                } else {
                    throw ReservationAccessException.forDuplicatedReservationTime();
                }
            } else {
                throw MeetingRoomNotFoundException.forMeetingRoomIdx();
            }
        }
    }

    public BaseResponse<List<GetEventRes>> listEvents(Member member, int year) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<EventParticipants> events = eventRepository.findEventParticipantsByYear(verifiedMember.getMemberIdx(), year);
        List<GetEventRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (EventParticipants event : events) {
                eventsList.add(GetEventRes.buildEventRes(event));
            }
            return BaseResponse.successRes("CALENDAR_002", true, "일정 조회를 성공하였습니다.", eventsList);
        } else {
            return BaseResponse.successRes("CALENDAR_002", true, "아직 일정이 없습니다.", eventsList);
        }
    }

    public BaseResponse<List<GetEventRes>> readEvent(Member member, String date) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<Event> events = eventRepository.findEventsByDate(verifiedMember.getMemberIdx(), date);
        List<GetEventRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (Event event : events) {
//                eventsList.add(GetEventRes.buildEventRes(verifiedMember, event));
            }
            return BaseResponse.successRes("CALENDAR_002", true, "일정이 상세 조회되었습니다.", eventsList);
        } else {
            return BaseResponse.successRes("CALENDAR_002", true, "아직 일정이 없습니다.", eventsList);
        }
    }

    public BaseResponse<PatchEventRes> updateEvent(Member member, PatchEventReq request) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                EventNotFoundException.forEventId(request.getEventIdx()));
        Long memberIdxOfEvent = verifiedMember.getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            Event updatedEvent = eventRepository.save(Event.setEvent(request, event));
            PatchEventRes patchEventRes = PatchEventRes.buildEventRes(updatedEvent);
            return BaseResponse.successRes("CALENDAR_004", true, "일정이 수정되었습니다.", patchEventRes);
        } else throw EventAccessException.forMemberId(verifiedMember.getMemberId());
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
            return BaseResponse.successRes("CALENDAR_005", true, "일정이 삭제되었습니다.", deleteEventRes);
        } else {
            throw EventAccessException.forMemberId(member.getMemberId());
        }
    }

    // 회의실 예약 생성
    @Transactional
    public BaseResponse<PatchReservationRes> createReservation(Member member, PatchReservationReq request) {
        memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));

        MeetingRoom meetingRoom = meetingRoomRepository.findById(request.getMeetingRoomIdx()).orElseThrow(() ->
                MeetingRoomNotFoundException.forMeetingRoomIdx());

        Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                EventNotFoundException.forEventId(request.getEventIdx()));

        if(reservationFilter.reservationFilter(request.getMeetingRoomIdx(), request.getReservationStart(), request.getReservationEnd())){
            Event reservation = Event.setReservation(request, meetingRoom, event);
            eventRepository.save(reservation);
            PatchReservationRes patchReservationRes = PatchReservationRes.buildReservationRes(reservation);
            return BaseResponse.successRes("MEETING_000", true, "회의실 예약이 완료되었습니다.", patchReservationRes);
        } else {
            throw ReservationAccessException.forReservationTime();
        }
    }

    // 회의실 예약 조회
    @Transactional
    public BaseResponse<List<GetReservationRes>> listReservations(Member member, Long meetingRoomIdx, String date) {
        memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<Event> events = eventRepository.findEventsByReservationTime(meetingRoomIdx, date);
        List<GetReservationRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (Event event : events) {
                eventsList.add(GetReservationRes.buildReservationRes(event));
            }
            return BaseResponse.successRes("MEETING_000", true, "회의실 예약 내역이 조회되었습니다.", eventsList);
        } else {
            return BaseResponse.successRes("MEETING_000", true, "아직 예약 내역이 없습니다.", null);
        }
    }

    public BaseResponse<DeleteReservationCancelRes> meetingRoomReservationCancel(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (!eventOptional.isPresent()) {
            throw new ReservationNotFoundException(ErrorCode.RESERVATION_NOT_FOUND, "예약을 찾을 수 없습니다.");
        }

        Event event = eventOptional.get();
        MeetingRoom meetingRoom = event.getMeetingRoom();
        eventParticipantsRepository.deleteByEvent(event);

        // 삭제 전에 updateAt 시간 저장
        event.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
        eventRepository.save(event);

        // 예약 정보 삭제
        eventRepository.deleteById(eventId);

        // 예약 정보
        DeleteReservationInfoRes reservationInfo = DeleteReservationInfoRes.buildCancel(event);

        // 예약 정보 포함해 응답
        DeleteReservationCancelRes deleteReservationCancelRes = DeleteReservationCancelRes
                .buildReservationCancel(meetingRoom, reservationInfo);
        return BaseResponse.successRes("EVENT_000", true, "---", deleteReservationCancelRes);
    }
}
