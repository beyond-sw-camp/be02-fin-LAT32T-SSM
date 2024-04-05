package com.project.batch.events.repository;

import com.project.batch.events.model.EventParticipants;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventParticipantsRepository extends JpaRepository<EventParticipants,Long> {

}
