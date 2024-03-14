package com.project.ssm.sharedevents.service;

import com.project.ssm.meetingroom.model.MeetingRoom;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import com.project.ssm.reservation.model.MeetingReservation;
import com.project.ssm.reservation.repository.MeetingRoomReservationRepository;
import com.project.ssm.sharedevents.model.SharedEvents;
import com.project.ssm.sharedevents.model.request.MeetingRoomReservationReq;
import com.project.ssm.sharedevents.model.response.MeetingRoomReservationCancleRes;
import com.project.ssm.sharedevents.model.response.MeetingRoomReservationRes;
import com.project.ssm.sharedevents.repository.SharedEventsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class SharedEventsService {
    private final MeetingRoomRepository meetingRoomRepository;
    private final SharedEventsRepository sharedEventsRepository;
    private final MemberRepository memberRepository;
    private final MeetingRoomReservationRepository meetingRoomReservationRepository;

    public MeetingRoomReservationRes meetingRoomReservation(MeetingRoomReservationReq request) {
        Optional<MeetingRoom> meetingRoomOptional = meetingRoomRepository.findById(request.getMeetingRoomIdx());
        if (!meetingRoomOptional.isPresent()) {
            return MeetingRoomReservationRes.builder().build(); // 회의실이 없을시 빈 결과 반환 추후 예외처리 구현 필요
        }
        MeetingRoom meetingRoom = meetingRoomOptional.get();

        boolean isOverlapping = sharedEventsRepository.isReservationDuplication(request.getMeetingRoomIdx(), request.getStartedAt(), request.getClosedAt());
        if (isOverlapping) {
            throw new IllegalStateException("이미 예약된 시간입니다.");
        }

        // 예약에 참여할 멤버들을 저장할 Set을 생성
        Set<Member> members = new HashSet<>();
        // 요청된 멤버 정보를 반복하면서 멤버를 조회하고 Set에 추가
        for (MeetingRoomReservationReq.MemberRequest memberRequest : request.getMembers()) {
            Optional<Member> memberOptional = memberRepository.findByMemberName(memberRequest.getMemberName());
            if (!memberOptional.isPresent()) {
                return MeetingRoomReservationRes.builder().build(); // 요청된 멤버 네임이 없을시 빈값 반환 추후 예외처리 구현 필요
            }
            members.add(memberOptional.get());
        }

        MeetingReservation newReservation = MeetingReservation.builder()
                .meetingRoom(meetingRoom)
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now())
                .build();
        newReservation = meetingRoomReservationRepository.save(newReservation);

        // 요청 데이터 저장
        SharedEvents sharedEvents = SharedEvents.builder()
                .reservation(newReservation)
                .startedAt(request.getStartedAt())
                .closedAt(request.getClosedAt())
                .build();
        SharedEvents savedSharedEvent = sharedEventsRepository.save(sharedEvents);

        // 응답
        return MeetingRoomReservationRes.builder()
                .result(MeetingRoomReservationRes.Result.builder()
                        .reservationIdx(savedSharedEvent.getEventIdx())
                        .roomName(meetingRoom.getRoomName())
                        .build())
                .build();
    }

    public MeetingRoomReservationCancleRes meetingRoomReservationCancel(Long sharedEventsId) {
        Optional<SharedEvents> byId = sharedEventsRepository.findById(sharedEventsId);
        if (!byId.isPresent()) {
            return MeetingRoomReservationCancleRes.builder().build(); // 예약 정보 없으면 빈값 반환. 추후 예외처리 구현 필요
        }
        SharedEvents sharedEvents = byId.get();

        MeetingReservation relatedReservation = sharedEvents.getReservation();
        MeetingRoom relatedMeetingRoom = relatedReservation.getMeetingRoom();
        // 삭제 전에 updateAt 시간 저장
        relatedReservation.setUpdatedAt(LocalDateTime.now());
        meetingRoomReservationRepository.save(relatedReservation);

        // 예약 정보 삭제
        sharedEventsRepository.deleteById(sharedEventsId);

        // 예약 정보
        MeetingRoomReservationCancleRes.Reservation reservationInfo = MeetingRoomReservationCancleRes.Reservation.builder()
                .reservationIdx(relatedReservation.getReservationIdx())
                .startedAt(sharedEvents.getStartedAt())
                .closedAt(sharedEvents.getClosedAt())
                .build();

        // 예약 정보 포함해 응답
        return MeetingRoomReservationCancleRes.builder()
                .result(MeetingRoomReservationCancleRes.Result.builder()
                        .meetingRoomIdx(relatedMeetingRoom.getMeetingRoomIdx()) // MeetingRoom의 ID 사용
                        .roomName(relatedMeetingRoom.getRoomName())
                        .roomNum(relatedMeetingRoom.getRoomNum())
                        .roomCapacity(relatedMeetingRoom.getRoomCapacity())
                        .reservations(Arrays.asList(reservationInfo)) // 취소된 예약 정보 포함
                        .build())
                .build();
    }
}

