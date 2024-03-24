package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.QEvent;
import com.project.ssm.events.model.entity.QEventParticipants;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.StringExpression;
import com.querydsl.core.types.dsl.StringPath;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class EventRepositoryImpl implements EventCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Event> findEventsByYear(Long memberIdx, int year) {
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
                                        event.startedAt.substring(0, 4).eq(String.valueOf(year))
                                                .or(event.closedAt.substring(0, 4).eq(String.valueOf(year)))
                                )
                )
                .fetch();
    }

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
                                        event.startedAt.substring(0).eq(date)
                                                .or(event.closedAt.substring(0).eq(date))
                                )
                )
                .fetch();
    }


    /**
     * 일정 알람을 위한 메소드
     */
    @Override
    public List<Event> findEventsByMemberIdx(Long memberIdx) {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;

        List<Event> eventList = queryFactory
                .select(event)
                .from(event)
                .leftJoin(eventParticipants)
                .on(event.eventIdx.eq(eventParticipants.event.eventIdx))
                .where(
                        eventParticipants.member.memberIdx.eq(memberIdx)
                )
                .fetch();


        return eventList;
    }
}
