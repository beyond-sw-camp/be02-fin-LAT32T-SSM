package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.events.model.entity.QEvent;

import com.project.ssm.events.model.entity.QEventParticipants;
import com.project.ssm.member.model.Member;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EventRepositoryImpl implements EventCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<EventParticipants> findEventsByYear(Long memberIdx, int year) {
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
//    public List<Event> findEventsByYear(Long memberIdx, int year) {
//        QEvent event = QEvent.event;
//        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;
//        return queryFactory
//                .select(event)
//                .from(event)
//                .leftJoin(eventParticipants)
//                .on(event.eventIdx.eq(eventParticipants.event.eventIdx))
//                .where(
//                        eventParticipants.member.memberIdx.eq(memberIdx)
//                                .and(
//                                        event.startedAt.substring(0, 4).eq(String.valueOf(year))
//                                                .or(event.closedAt.substring(0, 4).eq(String.valueOf(year)))
//                                )
//                )
//                .fetch();
//    }


    @Override
    public List<Event> findByYear(int year) {
        QEvent event = QEvent.event;
        return queryFactory
                .selectFrom(event)
                .where(
                        event.startedAt.substring(0, 4).eq(String.valueOf(year)).or(event.closedAt.substring(0, 4).eq(String.valueOf(year)))
                )
                .fetch();
    }

    @Override
    public List<Event> findEventsByDate(Long memberIdx, String date) {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;

        return queryFactory
                .select(event)
                .from(event)
                .leftJoin(eventParticipants)
                .on(event.eventIdx.eq(eventParticipants.event.eventIdx))
                .where(
                        eventParticipants.member.memberIdx.eq(memberIdx)
                                .and(
                                        event.startedAt.substring(0, 10).eq(date)
                                                .or(event.closedAt.substring(0, 10).eq(date))
                                )
                )
                .fetch();
    }

    @Override
    public List<Event> findEventsByReservationTime(Long meetingRoomIdx, String date) {
        QEvent event = QEvent.event;
        return queryFactory
                .selectFrom(event)
                .where(
                        event.meetingRoom.meetingRoomIdx.eq(meetingRoomIdx)
                                .and(
                                        event.startedAt.substring(0,10).eq(date)
                                                .or(event.closedAt.substring(0,10).eq(date))
                                )
                )
                .fetch();
    }


    /**
     * 일정 알람을 위한 메소드
     */


    @Override
    public List<EventParticipants> findMemberByEventTime() {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;

        List<EventParticipants> eventList = queryFactory
                .select(eventParticipants)
                .from(eventParticipants)
                .leftJoin(event)
                .on(eventParticipants.event.eventIdx.eq(event.eventIdx))
                .where(
                        // startedAt을 날짜/시간으로 변환
                        Expressions.numberTemplate(Integer.class,
                                        "TIMESTAMPDIFF(MINUTE, STR_TO_DATE({0}, '%Y-%m-%d %H:%i'), CURRENT_TIMESTAMP)",
                                        event.startedAt)
                                // 현재 시간과의 차이가 10분 이내인 경우
                                .loe(10)
                )
                .fetch();

        return eventList;
    }
}
