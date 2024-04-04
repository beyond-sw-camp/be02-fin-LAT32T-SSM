package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.model.entity.QEvent;

import com.project.ssm.events.model.entity.QEventParticipants;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.meetingroom.model.entity.QMeetingRoom;
import com.project.ssm.member.model.Member;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.DateTimeExpression;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;

@RequiredArgsConstructor
public class EventRepositoryImpl implements EventCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Event> findEventsByMemberIdx(Long memberIdx) {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;

        return queryFactory
                .select(event)
                .from(event)
                .leftJoin(eventParticipants)
                .on(event.eventIdx.eq(eventParticipants.event.eventIdx))
                .where(eventParticipants.member.memberIdx.eq(memberIdx))
                .fetch();
    }

    @Override
    public List<EventParticipants> findEventParticipantsByYear(Long memberIdx, int year) {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;
        return queryFactory
                .select(eventParticipants)
                .from(eventParticipants)
                .leftJoin(event)
                .on(eventParticipants.event.eventIdx.eq(event.eventIdx))
                .where(
                        event.startedAt.substring(0, 4).eq(String.valueOf(year))
                                .or(event.closedAt.substring(0, 4).eq(String.valueOf(year)))
                )
                .fetch();
    }

//    @Override
//    public List<Event> findEventsByDate(Long memberIdx, String date) {
//        QEvent event = QEvent.event;
//        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;
//
//        return queryFactory
//                .select(event)
//                .from(event)
//                .leftJoin(eventParticipants)
//                .on(event.eventIdx.eq(eventParticipants.event.eventIdx))
//                .where(
//                        eventParticipants.member.memberIdx.eq(memberIdx)
//                                .and(
//                                        event.startedAt.substring(0, 10).eq(date)
//                                                .or(event.closedAt.substring(0, 10).eq(date))
//                                )
//                )
//                .fetch();
//    }

    @Override
    public List<Event> findEventsByReservationTime(Long meetingRoomIdx, String date) {
        QEvent event = QEvent.event;
        return queryFactory
                .selectFrom(event)
                .where(
                        event.meetingRoom.meetingRoomIdx.eq(meetingRoomIdx)
                                .and(
                                        event.startedAt.substring(0, 10).eq(date)
                                                .or(event.closedAt.substring(0, 10).eq(date))
                                )
                )
                .fetch();
    }

    /**
     * 일정 알람을 위한 메소드
     * String 타입의 startedAt을 Date 타입으로 바꾸고
     * 이벤트참가 테이블과 이벤트 테이블 조인을 해서 현재 시간 기준 10분 이후 데이터를 뽑는다.
     * 나오는 멤버를 찾아서 emitter로 메세지를 보낸다.
     */
    @Override
    public List<EventParticipants> findMemberByEventTime() {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;

        LocalDateTime now = LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        LocalDateTime tenMinutesAfter = now.plusMinutes(10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String tenMinutesAfterStr = tenMinutesAfter.format(formatter);
        String nowStr = now.format(formatter);

        List<EventParticipants> eventParticipantsList = queryFactory
                .select(eventParticipants)
                .from(eventParticipants)
                .leftJoin(event)
                .on(eventParticipants.event.eventIdx.eq(event.eventIdx))
                .where(
                        // MySQL의 STR_TO_DATE 함수를 사용하여 String을 날짜/시간 타입으로 변환
                        Expressions.stringTemplate("DATE_FORMAT({0}, {1})"
                                        , event.startedAt
                                        , ConstantImpl.create("%Y-%m-%d %H:%i"))
                                .between(nowStr, tenMinutesAfterStr)
                        // 스트링  데이트타입    스트링 사이에서
                )
                .fetch();
        return eventParticipantsList;
    }

    @Override
    public List<Event> findAllByMeetingRoomIdx(Long meetingRoomIdx) {
        QEvent event = QEvent.event;

        return queryFactory.selectFrom(event)
                .where(event.meetingRoom.meetingRoomIdx.eq(meetingRoomIdx))
                .fetch();
    }
}
