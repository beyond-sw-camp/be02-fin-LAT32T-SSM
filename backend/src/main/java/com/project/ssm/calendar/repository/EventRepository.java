package com.project.ssm.calendar.repository;

import com.project.ssm.calendar.model.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EventRepository extends JpaRepository<Event,Long>, EventCustomRepository {
    Optional<Event> findById(Long eventIdx);


}
