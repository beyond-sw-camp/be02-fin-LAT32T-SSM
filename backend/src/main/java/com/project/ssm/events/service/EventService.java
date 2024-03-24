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
import com.project.ssm.meetingroom.model.request.PostReservationReq;
import com.project.ssm.meetingroom.model.response.PostReservationRes;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.member.exception.MemberNotFoundException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
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

    // 회의실 예약 없이
    @Transactional
    public BaseResponse<PostEventRes> createEvent(Member member, PostEventReq request) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        Optional<MeetingRoom> result = meetingRoomRepository.findByMeetingRoomIdx(request.getMeetingRoomIdx());
        MeetingRoom meetingRoom;
        if (result.isPresent()) {
            meetingRoom = result.get();
        } else {
            if(request.getMeetingRoomIdx()==null) {meetingRoom = null;}
            else{
                throw MeetingRoomNotFoundException.forMeetingRoomIdx();
            }
        }
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
            throw ReservationAccessException.forReservationTime();
        }
    }

    public List<GetEventRes> listEvents(Member member, int year) {
        Member verifiedMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        List<Event> events = eventRepository.findEventsByYear(verifiedMember.getMemberIdx(), year);
        List<GetEventRes> eventsList = new ArrayList<>();
        if (!events.isEmpty()) {
            for (Event event : events) {
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
            for (Event event : events) {
                eventsList.add(GetEventRes.buildEventRes(verifiedMember, event));
            }
            return BaseResponse.successRes("CALENDAR_002", true, "일정이 상세 조회되었습니다.", eventsList);
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
    public BaseResponse<PostReservationRes> createReservation(Member member, PatchReservationReq request) {
        memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));

        MeetingRoom meetingRoom = meetingRoomRepository.findById(request.getMeetingRoomIdx()).orElseThrow(() ->
                MeetingRoomNotFoundException.forMeetingRoomIdx());

        Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                EventNotFoundException.forEventId(request.getEventIdx()));

        if(reservationFilter.reservationFilter(request.getMeetingRoomIdx(), request.getReservationStart(), request.getReservationEnd())){
            Event reservation = Event.setReservation(request, meetingRoom, event);
            eventRepository.save(reservation);
            PostReservationRes postReservationRes = PostReservationRes.buildReservationRes(reservation);
            return BaseResponse.successRes("MEETING_000", true, "회의실 예약이 완료되었습니다.", postReservationRes);
        } else {
            throw ReservationAccessException.forReservationTime();
        }
    }

    // 회의실 예약 조회
    // 날짜 별로 조회
    // 일단 날짜 받아 레포지토리에 findByReservationTime 만들어
    // 이벤트에 meetingRoomReservationTime을 받아서 저장 시킨 담에 조회
    // 조회할때는 meeitngRoomIdx에서 meetingRoomReservationTime이 조회하려는 날짜랑 같으면 될 듯
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
            // 찾는 데이터가 없을 경우 예외 처리
//            for (Event event: events) {
//            }
            Long eventIdx = null;
            throw EventNotFoundException.forEventId(eventIdx);
        }
    }

//    // Reservation Filter
//    // 예약하려는 이벤트 시작시간이 종료시간보다 앞에 있어야 함
//    // 예약하려는 이벤트 시작시간이 예약내역 이벤트의 끝시간 앞에 있거나
//    // 예약하려는 이벤트 종료시간이 예약내역 이벤트의 시작시간 앞에 있거나
//    public Boolean reservationFilter(Long meetingRoomIdx, String startedAt, String closedAt){
//        Boolean result = null;
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        String date = startedAt.substring(0,9);
//        // date에 회의실이 예약된 이벤트 내역들
//        List<Event> events = eventRepository.findEventsByReservationTime(meetingRoomIdx, date);
//        for (Event event: events) {
//            try {
//                // 예약내역 이벤트의 시작시간
//                Date bookedEventStartTime = sdf.parse(event.getStartedAt());
//                // 예약내역 이벤트의 끝시간
//                Date bookedEventCloseTime = sdf.parse(event.getClosedAt());
//                // 예약하려는 이벤트 시작시간
//                Date reservationStartTime = sdf. parse(startedAt);
//                // 예약하려는 이벤트 종료시간
//                Date reservationCloseTime = sdf. parse(closedAt);
//                if((reservationStartTime.before(reservationCloseTime))&&
//                        (reservationStartTime.before(bookedEventCloseTime)||(reservationCloseTime.after(bookedEventStartTime)))){
//                    result = true;
//                } else {
//                    result = false;
//                }
//            } catch (ParseException e) {
//                throw new RuntimeException(e);
//            }
//        }
//        return result;
//    }


//    public BaseResponse<MeetingRoomReservationRes> meetingRoomReservation(MeetingRoomReservationReq request) {
//        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());
//
//        if (!meetingRoomOptional.isPresent()) {
//            throw new MeetingRoomNotFoundException(ErrorCode.MEETINGROOM_NOT_FOUND, "회의실을 찾을 수 없습니다.");
//        }
//        MeetingRoom meetingRoom = meetingRoomOptional.get();
//
//        if (request.getMembers().size() > meetingRoom.getMeetingRoomCapacity()) {
//            throw new ReservationOverException(ErrorCode.RESERVATION_OVER, "인원이 초과 되었습니다.");
//        }
//
//        Event savedEvent = eventRepository.save(Event.buildRoomEvent(meetingRoom, request));
//
//        for (MeetingRoomReqMemberRequest memberRequest : request.getMembers()) {
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
    //@Transactional
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
