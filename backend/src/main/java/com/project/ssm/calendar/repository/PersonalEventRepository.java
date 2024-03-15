package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonalEventRepository extends JpaRepository<PersonalEvent,Long>, PersonalEventCustomRepository {
    Optional<PersonalEvent> findById(Long eventIdx);
}
