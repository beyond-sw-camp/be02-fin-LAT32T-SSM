package com.project.ssm.events.repository;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.model.entity.EventParticipants;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import java.util.List;

public interface EventCustomRepository {
    List<Event> findEventsByMemberIdx(Long memberIdx);

    /**
     * 1년 단위에 모든 이벤트를 받는 메서드
     */
    List<EventParticipants> findEventParticipantsByYear(Long memberIdx, int year);

    /**
     * 전월 후월을 받아서 3개월치의 이벤트를 계산하는 메서드
     */
    List<EventParticipants> findEventParticipantsBetweenDates(String start, String end);

    List<Event> findEventsByReservationTime(Long meetingRoomIdx, String date);

    /**
     * 일정 알람을 위한 메소드
     */
    List<EventParticipants> findMemberByEventTime();

    List<Event> findAllByMeetingRoomIdx(Long meetingRoomIdx);

}

