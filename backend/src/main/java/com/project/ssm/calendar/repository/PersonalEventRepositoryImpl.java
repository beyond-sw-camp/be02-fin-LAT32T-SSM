package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.calendar.model.entity.QPersonalEvent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class PersonalEventRepositoryImpl implements PersonalEventCustomRepository{

    private final JPAQueryFactory queryFactory;

    @Override
    public List<PersonalEvent> findByYear(int year) {
        QPersonalEvent personalEvent = QPersonalEvent.personalEvent;
        return queryFactory
                .selectFrom(personalEvent)
                .where(personalEvent.startedAt.year().eq(year)
                        .or(personalEvent.closedAt.year().eq(year)))
                .fetch();
    }
}
