package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;

import java.util.List;

public interface EventCustomRepository {

    List<EventParticipants> findEventParticipantsByYear(Long memberIdx, int year);

    List<Event> findByYear(int year);

    List<Event> findEventsByDate(Long memberIdx, String date);

    List<Event> findEventsByReservationTime(Long meetingRoomIdx, String date);

    List<Event> findEventsByCurrentTime(String date);


    /**
     * 일정 알람을 위한 메소드
     */
    List<EventParticipants> findMemberByEventTime();
}

