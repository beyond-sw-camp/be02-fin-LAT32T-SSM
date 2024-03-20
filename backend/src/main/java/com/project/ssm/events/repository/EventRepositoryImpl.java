package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.QEvent;
import com.project.ssm.events.model.entity.QEventParticipants;
import com.querydsl.core.Tuple;
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
                        event.startedAt.substring(0,4).eq(String.valueOf(year)).or(event.closedAt.substring(0,4).eq(String.valueOf(year)))
                )
                .fetch()
                ;
    }

    @Override
    public List<Event> findEventsByDate(Long memberIdx, String date) {
        return null;
    }


}
