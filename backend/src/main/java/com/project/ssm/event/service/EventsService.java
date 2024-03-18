package com.project.ssm.event.service;

import com.project.ssm.event.model.Events;
import com.project.ssm.event.model.request.MeetingRoomReservationReq;
import com.project.ssm.event.model.response.MeetingRoomReservationCancelRes;
import com.project.ssm.event.model.response.MeetingRoomReservationRes;
import com.project.ssm.event.repository.EventsRepository;
import com.project.ssm.eventparticipants.model.EventParticipants;
import com.project.ssm.eventparticipants.repository.EventParticipantsRepository;
import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EventsService {
    private final MeetingRoomRepository meetingRoomRepository;
    private final EventsRepository eventsRepository;
    private final MemberRepository memberRepository;
    private final EventParticipantsRepository eventParticipantsRepository;
    public MeetingRoomReservationRes meetingRoomReservation(MeetingRoomReservationReq request) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());
        if (!meetingRoomOptional.isPresent()) {
            return MeetingRoomReservationRes.builder().build(); // 회의실이 없을시 빈 결과 반환 추후 예외처리 구현 필요
        }
        MeetingRoom meetingRoom = meetingRoomOptional.get();

        boolean isOverlapping = eventsRepository.isReservationDuplication(request.getMeetingRoomIdx(), request.getStartedAt(), request.getClosedAt());
        if (isOverlapping) {
            throw new IllegalStateException("이미 예약된 시간입니다.");
        }

        Events event = Events.builder()
                .meetingRoom(meetingRoom)
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now())
                .startedAt(request.getStartedAt())
                .closedAt(request.getClosedAt())
                .build();
        Events savedEvent = eventsRepository.save(event);

        for (MeetingRoomReservationReq.MemberRequest memberRequest : request.getMembers()) {
            Optional<Member> memberOptional = memberRepository.findByMemberName(memberRequest.getMemberName());
            if (memberOptional.isPresent()) {
                Member member = memberOptional.get();
                EventParticipants eventParticipant = EventParticipants.builder()
                        .event(savedEvent)
                        .member(member)
                        .build();
                eventParticipantsRepository.save(eventParticipant);
            }
        }
        // 응답
        return MeetingRoomReservationRes.builder()
                .result(MeetingRoomReservationRes.Result.builder()
                        .eventIdx(savedEvent.getEventIdx())
                        .roomName(meetingRoom.getMeetingRoomName())
                        .build())
                .build();
    }

    // 외래키가 먼저 삭제되야 하므로 트랜젝션 처리
    @Transactional
    public MeetingRoomReservationCancelRes meetingRoomReservationCancel(Long eventId) {
        Optional<Events> eventOptional = eventsRepository.findById(eventId);
        if (!eventOptional.isPresent()) {
            return MeetingRoomReservationCancelRes.builder().build(); // 예약 정보 없으면 빈값 반환. 추후 예외처리 구현 필요
        }
        Events event = eventOptional.get();
        MeetingRoom meetingRoom = event.getMeetingRoom();

        eventParticipantsRepository.deleteByEvent(event);

        // 삭제 전에 updateAt 시간 저장
        event.setUpdatedAt(LocalDateTime.now());
        eventsRepository.save(event);

        // 예약 정보 삭제
        eventsRepository.deleteById(eventId);

        // 예약 정보
        MeetingRoomReservationCancelRes.Reservation reservationInfo = MeetingRoomReservationCancelRes.Reservation.builder()
                .eventIdx(event.getEventIdx())
                .createdAt(event.getCreatedAt())
                .updatedAt(LocalDateTime.now())
                .startedAt(event.getStartedAt())
                .closedAt(event.getClosedAt())
                .build();


        // 예약 정보 포함해 응답
        return MeetingRoomReservationCancelRes.builder()
                .result(MeetingRoomReservationCancelRes.Result.builder()
                        .roomIdx(meetingRoom.getMeetingRoomIdx())    // 미팅룸 정보
                        .roomName(meetingRoom.getMeetingRoomName())
                        .roomCapacity(meetingRoom.getMeetingRoomCapacity())
                        .reservations(Arrays.asList(reservationInfo))   // 예약 정보
                        .build())
                .build();
    }
}

