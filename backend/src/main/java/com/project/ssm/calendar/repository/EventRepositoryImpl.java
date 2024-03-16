package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.Event;
import com.project.ssm.calendar.model.entity.QEvent;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RequiredArgsConstructor
public class EventRepositoryImpl implements EventCustomRepository {

    private final JPAQueryFactory queryFactory;

    @Override
    public List<Event> findByYear(int year) {

//        String startedAt = "2019-06-04 17:47";
//        LocalDateTime dateTime = LocalDateTime.parse(startedAt, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
//        int year = dateTime.getYear();

        QEvent Event = QEvent.event;

        String startTime = Event.startedAt.toString();
        LocalDateTime startDateTime = LocalDateTime.parse(startTime, DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        int eventYear = startDateTime.getYear();

        return queryFactory
                .selectFrom(Event)
//                .where(startDateTime.getYear())
                .fetch();
    }
}
