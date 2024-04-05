package com.project.batch.events.repository;


import com.project.batch.events.model.EventParticipants;

import java.util.List;

public interface EventCustomRepository {

    /**
     * 일정 알람을 위한 메소드
     */
    List<EventParticipants> findMemberByEventTime();

}

