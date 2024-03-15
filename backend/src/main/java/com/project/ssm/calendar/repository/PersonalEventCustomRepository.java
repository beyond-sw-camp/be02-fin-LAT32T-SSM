package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.PersonalEvent;

import java.util.List;

public interface PersonalEventCustomRepository {
    List<PersonalEvent> findByYear(int year);
}

