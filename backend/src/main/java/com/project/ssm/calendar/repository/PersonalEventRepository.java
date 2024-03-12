package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.PersonalEvent;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalEventRepository extends JpaRepository<PersonalEvent,Long> {
}
