package com.project.ssm.sharedevents.repository;

import com.project.ssm.sharedevents.model.SharedEvents;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SharedEventsRepository extends JpaRepository<SharedEvents,Long> {

}
