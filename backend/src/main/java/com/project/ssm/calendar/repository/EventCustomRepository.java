package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.Event;

import java.util.List;

public interface EventCustomRepository {
    List<Event> findEventsByYear(Long memberIdx, int year);

    List<Event> findByYear(int year);
}

