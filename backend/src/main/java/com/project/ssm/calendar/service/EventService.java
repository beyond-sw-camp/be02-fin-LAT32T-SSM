package com.project.ssm.calendar.service;

import com.project.ssm.calendar.exception.CalendarAccessException;
import com.project.ssm.calendar.exception.CalendarNotFoundException;
import com.project.ssm.calendar.model.entity.Event;
import com.project.ssm.calendar.model.request.PatchEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.calendar.model.response.*;
import com.project.ssm.calendar.repository.EventRepository;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.calendar.model.entity.EventParticipants;
import com.project.ssm.calendar.model.request.MeetingRoomReservationReq;
import com.project.ssm.calendar.model.response.DeleteReservationCancelRes;
import com.project.ssm.calendar.model.response.DeleteReservationInfoRes;
import com.project.ssm.calendar.model.response.MeetingRoomReservationRes;
import com.project.ssm.calendar.repository.EventParticipantsRepository;
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
    public BaseResponse create(Member member, PostEventReq request) {
        com.project.ssm.calendar.model.entity.Event event = eventRepository.save(com.project.ssm.calendar.model.entity.Event.buildEvent(member, request));
        PostEventRes postEventRes = PostEventRes.buidEventRes(event, member);
        return BaseResponse.builder()
                .code("CALENDAR_001")
                .isSuccess(true)
                .message("새로운 일정이 생성되었습니다.")
                .result(postEventRes)
                .build();
    }

    public Object read(Member member, Long eventIdx) {
        com.project.ssm.calendar.model.entity.Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
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
        com.project.ssm.calendar.model.entity.Event event = eventRepository.findById(request.getEventIdx()).orElseThrow(() ->
                CalendarNotFoundException.forEventId(request.getEventIdx()));
        Long memberIdxOfEvent = event.getMember().getMemberIdx();
        if (memberIdxOfEvent.equals(member.getMemberIdx())) {
            com.project.ssm.calendar.model.entity.Event updatedEvent = com.project.ssm.calendar.model.entity.Event.setEvent(request, event);
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
        com.project.ssm.calendar.model.entity.Event event = eventRepository.findById(eventIdx).orElseThrow(() ->
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

    public MeetingRoomReservationRes meetingRoomReservation(MeetingRoomReservationReq request) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());

        if (!meetingRoomOptional.isPresent()) {
            return MeetingRoomReservationRes.builder().build(); // 회의실이 없을시 빈 결과 반환 추후 예외처리 구현 필요
        }
        MeetingRoom meetingRoom = meetingRoomOptional.get();

        boolean isOverlapping = eventRepository.isReservationDuplication(request.getMeetingRoomIdx(), request.getStartedAt(), request.getClosedAt());
        if (isOverlapping) {
            throw new IllegalStateException("이미 예약된 시간입니다.");
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
        return MeetingRoomReservationRes.buildReservationRes(savedEvent.getEventIdx(), meetingRoom.getMeetingRoomName());
    }

    // 외래키가 먼저 삭제되야 하므로 트랜젝션 처리
    @Transactional
    public DeleteReservationCancelRes meetingRoomReservationCancel(Long eventId) {
        Optional<Event> eventOptional = eventRepository.findById(eventId);
        if (!eventOptional.isPresent()) {
            return DeleteReservationCancelRes.builder().build(); // 예약 정보 없으면 빈값 반환. 추후 예외처리 구현 필요
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
        return DeleteReservationCancelRes.buildReservationCancel(meetingRoom, reservationInfo);
    }

}
