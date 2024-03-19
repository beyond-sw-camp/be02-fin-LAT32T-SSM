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
    private final MeetingRoomRepository meetingRoomRepository;
    private final MemberRepository memberRepository;
    private final EventParticipantsRepository eventParticipantsRepository;

    @Transactional
    public BaseResponse<PostEventRes> create(Member member, PostEventReq request) {
        Event event = eventRepository.save(Event.buildEvent(member, request));
        PostEventRes postEventRes = PostEventRes.buidEventRes(event, member);
        return BaseResponse.successRes("EVENT_000", true, "---", postEventRes);
    }

    public BaseResponse<GetEventRes> read(Member member, Long eventIdx) {
        Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
                EventNotFoundException.forEventId(eventIdx));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            return BaseResponse.successRes("EVENT_000", true, "---", GetEventRes.buildEventRes(event));
        } else {
            throw EventAccessException.forMemberId(member.getMemberId());
        }
    }

    public BaseResponse<List<GetEventRes>> list(Member member, int year) {
        List<Event> events = eventRepository.findEventsByYear(member.getMemberIdx(), year);
        if (!events.isEmpty()) {
            List<GetEventRes> eventsList = new ArrayList<>();
            for (Event event: events) {
                eventsList.add(GetEventRes.buildEventRes(event));
            }
            return BaseResponse.successRes("EVENT_000", true, "---", eventsList);
        } else {
            
            // 찾는 데이터가 없을 경우 예외 처리
            
            return null;
        }
    }

    public BaseResponse<PatchEventRes> update(Member member, PatchEventReq request) {
        Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                EventNotFoundException.forEventId(request.getEventIdx()));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            Event updatedEvent = eventRepository.save(Event.setEvent(request, event));
            PatchEventRes patchEventRes = PatchEventRes.buildEventRes(updatedEvent);
            return BaseResponse.successRes("EVENT_000", true, "---", patchEventRes);
        } else {
            // 예외 처리 (수정 필요)
            throw EventAccessException.forMemberId(member.getMemberId());
        }
    }

    public BaseResponse<DeleteEventRes> delete(Member member, Long eventIdx) {
        Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
                EventNotFoundException.forEventId(eventIdx));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            eventRepository.delete(event);
            DeleteEventRes deleteEventRes = DeleteEventRes.buildEventRes(event);
            return BaseResponse.successRes("EVENT_000", true, "---", deleteEventRes);
        } else {
            // 예외 처리 수정 필요
            throw EventAccessException.forMemberId(member.getMemberId());
        }
    }

    public BaseResponse<MeetingRoomReservationRes> meetingRoomReservation(MeetingRoomReservationReq request) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());

        if (!meetingRoomOptional.isPresent()) {
            throw new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "회의실을 찾을 수 없습니다.");
        }
        MeetingRoom meetingRoom = meetingRoomOptional.get();

        boolean isOverlapping = eventRepository.isReservationDuplication(request.getMeetingRoomIdx(), request.getStartedAt(), request.getClosedAt());
        if (isOverlapping) {
            throw new ReservationDuplicateException(ErrorCode.RESERVATION_DUPLICATE, "이미 예약된 시간입니다.");
        }

        if (request.getMembers().size() > meetingRoom.getMeetingRoomCapacity()) {
            throw new ReservationOverException(ErrorCode.RESERVATION_OVER, "인원이 초과 되었습니다.");
        }

        Event savedEvent = eventRepository.save(Event.buildRoomEvent(meetingRoom, request));

        for (MeetingRoomReservationReq.MemberRequest memberRequest : request.getMembers()) {
            Optional<Member> memberOptional = memberRepository.findByMemberName(memberRequest.getMemberName());
            if (memberOptional.isPresent()) {
                Member member = memberOptional.get();
                eventParticipantsRepository.save(EventParticipants.buildEventPart(savedEvent, member));
            }
        }

        // 응답
        MeetingRoomReservationRes meetingRoomReservationRes = MeetingRoomReservationRes.
                buildReservationRes(savedEvent.getEventIdx(), meetingRoom.getMeetingRoomName());
        return BaseResponse.successRes("EVENT_000", true, "---", meetingRoomReservationRes);
    }

    // 외래키가 먼저 삭제되야 하므로 트랜젝션 처리
    @Transactional
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
