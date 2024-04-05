package com.project.batch.events.repository;

import com.project.batch.events.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;


public interface EventRepository extends JpaRepository<Event,Long>, EventCustomRepository {

}
