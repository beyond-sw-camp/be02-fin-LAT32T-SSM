package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;

import java.util.List;

public interface EventCustomRepository {
    List<Event> findEventsByYear(Long memberIdx, int year);

    List<Event> findByYear(int year);

    List<Event> findEventsByDate(Long memberIdx, String date);
}

