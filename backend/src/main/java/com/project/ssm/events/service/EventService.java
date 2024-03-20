package com.project.ssm.events.service;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.events.exception.*;
import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.model.request.MeetingRoomReservationReq;
import com.project.ssm.events.model.request.MeetingRoomReqMemberRequest;
import com.project.ssm.events.model.request.PatchEventReq;
import com.project.ssm.events.model.request.PostEventReq;
import com.project.ssm.events.model.response.*;
import com.project.ssm.events.repository.EventParticipantsRepository;
import com.project.ssm.events.repository.EventRepository;
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
    private final MeetingRoomRepository meetingRoomRepository;
    private final MemberRepository memberRepository;
    private final EventParticipantsRepository eventParticipantsRepository;

    @Transactional
    public BaseResponse<PostEventRes> createEvent(Member member, PostEventReq request) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Event event = eventRepository.save(Event.buildEvent(verifiedMember, request));
        eventParticipantsRepository.save(EventParticipants.buildEventPart(event,verifiedMember));
        PostEventRes postEventRes = PostEventRes.buidEventRes(event, verifiedMember);
        return BaseResponse.successRes("EVENT_000", true, "일정이 등록되었습니다.", postEventRes);
    }

    public BaseResponse<List<GetEventRes>> listEvents(Member member, int year) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<Event> events = eventRepository.findEventsByYear(verifiedMember.getMemberIdx(), year);
        List<GetEventRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (Event event: events) {
                eventsList.add(GetEventRes.buildEventRes(verifiedMember, event));
            }
            return BaseResponse.successRes("EVENT_000", true, "일정이 조회되었습니다.", eventsList);
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
            return BaseResponse.successRes("EVENT_000", true, "일정이 상세 조회되었습니다.", eventsList);
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
            return BaseResponse.successRes("EVENT_000", true, "일정이 수정되었습니다.", patchEventRes);
        }
        else throw EventAccessException.forMemberId(verifiedMember.getMemberId());
    }

    public BaseResponse<DeleteEventRes> deleteEvent(Member member, Long eventIdx) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
                EventNotFoundException.forEventId(eventIdx));
        Long memberIdxOfEvent = verifiedMember.getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            eventRepository.delete(event);
            DeleteEventRes deleteEventRes = DeleteEventRes.buildEventRes(event);
            return BaseResponse.successRes("EVENT_000", true, "일정이 삭제되었습니다.", deleteEventRes);
        } else {
            throw EventAccessException.forMemberId(member.getMemberId());
        }
    }
    public BaseResponse<MeetingRoomReservationRes> meetingRoomReservation(MeetingRoomReservationReq request) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());

        if (!meetingRoomOptional.isPresent()) {
            throw new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "회의실을 찾을 수 없습니다.");
        }
        MeetingRoom meetingRoom = meetingRoomOptional.get();
      
        if (request.getMembers().size() > meetingRoom.getMeetingRoomCapacity()) {
            throw new ReservationOverException(ErrorCode.RESERVATION_OVER, "인원이 초과 되었습니다.");
        }

        Event savedEvent = eventRepository.save(Event.buildRoomEvent(meetingRoom, request));

        for (MeetingRoomReqMemberRequest memberRequest : request.getMembers()) {
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

        // 여기 수정하셔도 됩니다.
//    public BaseResponse<MeetingRoomReservationRes> meetingRoomReservation(MeetingRoomReservationReq request) {
//        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());
//
//        if (!meetingRoomOptional.isPresent()) {
//            throw new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "회의실을 찾을 수 없습니다.");
//        }
//        MeetingRoom meetingRoom = meetingRoomOptional.get();
//
//        boolean isOverlapping = eventRepository.isReservationDuplication(request.getMeetingRoomIdx(), request.getStartedAt(), request.getClosedAt());
//        if (isOverlapping) {
//            throw new ReservationDuplicateException(ErrorCode.RESERVATION_DUPLICATE, "이미 예약된 시간입니다.");
//        }

        

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

//
//        if (request.getMembers().size() > meetingRoom.getMeetingRoomCapacity()) {
//            throw new ReservationOverException(ErrorCode.RESERVATION_OVER, "인원이 초과 되었습니다.");
//        }
//
//        Event savedEvent = eventRepository.save(Event.buildRoomEvent(meetingRoom, request));
//
//        for (MeetingRoomReservationReq.MemberRequest memberRequest : request.getMembers()) {
//            Optional<Member> memberOptional = memberRepository.findByMemberName(memberRequest.getMemberName());
//            if (memberOptional.isPresent()) {
//                Member member = memberOptional.get();
//                eventParticipantsRepository.save(EventParticipants.buildEventPart(savedEvent, member));
//            }
//        }
//
//        // 응답
//        MeetingRoomReservationRes meetingRoomReservationRes = MeetingRoomReservationRes.
//                buildReservationRes(savedEvent.getEventIdx(), meetingRoom.getMeetingRoomName());
//        return BaseResponse.successRes("EVENT_000", true, "---", meetingRoomReservationRes);
//    }
//
//    // 외래키가 먼저 삭제되야 하므로 트랜젝션 처리
//    @Transactional
//    public BaseResponse<DeleteReservationCancelRes> meetingRoomReservationCancel(Long eventId) {
//        Optional<Event> eventOptional = eventRepository.findById(eventId);
//        if (!eventOptional.isPresent()) {
//            throw new ReservationNotFoundException(ErrorCode.RESERVATION_NOT_FOUND, "예약을 찾을 수 없습니다.");
//        }
//
//        Event event = eventOptional.get();
//        MeetingRoom meetingRoom = event.getMeetingRoom();
//        eventParticipantsRepository.deleteByEvent(event);
//
//        // 삭제 전에 updateAt 시간 저장
//        event.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
//        eventRepository.save(event);
//
//        // 예약 정보 삭제
//        eventRepository.deleteById(eventId);
//
//        // 예약 정보
//        DeleteReservationInfoRes reservationInfo = DeleteReservationInfoRes.buildCancel(event);
//
//        // 예약 정보 포함해 응답
//        DeleteReservationCancelRes deleteReservationCancelRes = DeleteReservationCancelRes
//                .buildReservationCancel(meetingRoom, reservationInfo);
//        return BaseResponse.successRes("EVENT_000", true, "---", deleteReservationCancelRes);
//    }
}
