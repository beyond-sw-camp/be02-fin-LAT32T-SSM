package com.project.batch.events.repository;

import com.project.batch.events.model.EventParticipants;
import com.project.batch.events.model.QEvent;
import com.project.batch.events.model.QEventParticipants;
import com.querydsl.core.types.ConstantImpl;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class EventRepositoryImpl implements EventCustomRepository {

    private final JPAQueryFactory queryFactory;

    /**
     * 일정 알람을 위한 메소드
     * String 타입의 startedAt을 Date 타입으로 바꾸고
     */

    @Override
    public List<EventParticipants> findMemberByEventTime() {
        QEvent event = QEvent.event;
        QEventParticipants eventParticipants = QEventParticipants.eventParticipants;

        LocalDateTime now = LocalDateTime.now();
        LocalDateTime tenMinutesAfter = now.plusMinutes(10);

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        String formattedNow = now.format(formatter);
        String formattedTenMinutesAfter = tenMinutesAfter.format(formatter);

        return queryFactory
                .selectFrom(eventParticipants)
                .leftJoin(eventParticipants.event, event).fetchJoin()
                .where(
                        Expressions.stringTemplate(
                                "DATE_FORMAT({0}, {1})",
                                event.startedAt,
                                ConstantImpl.create("%Y-%m-%d %H:%i")
                        ).between(formattedNow, formattedTenMinutesAfter)
                )
                .fetch();
    }

}
