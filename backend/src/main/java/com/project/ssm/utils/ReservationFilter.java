package com.project.ssm.utils;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.member.exception.MemberNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class ReservationFilter {

    private final EventRepository eventRepository;

    // Reservation Filter
    // 예약하려는 이벤트 시작시간이 종료시간보다 앞에 있어야 함
    // 예약하려는 이벤트 시작시간이 예약내역 이벤트의 끝시간 앞에 있거나
    // 예약하려는 이벤트 종료시간이 예약내역 이벤트의 시작시간 앞에 있거나
    public Boolean reservationFilter(Long meetingRoomIdx, String startedAt, String closedAt) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = startedAt.substring(0, 10);
        // date에 회의실이 예약된 이벤트 내역들
        List<Event> events = eventRepository.findEventsByReservationTime(meetingRoomIdx, date);

        Boolean result = false;

        if (events.isEmpty()) {
            result = true;
        } else {
            for (Event event : events) {
                try {
                    // 예약내역 이벤트의 시작시간
                    Date bookedEventStartTime = sdf.parse(event.getStartedAt());
                    // 예약내역 이벤트의 끝시간
                    Date bookedEventCloseTime = sdf.parse(event.getClosedAt());
                    // 예약하려는 이벤트 시작시간
                    Date reservationStartTime = sdf.parse(startedAt);
                    // 예약하려는 이벤트 종료시간
                    Date reservationCloseTime = sdf.parse(closedAt);
                    if (reservationStartTime.after(bookedEventStartTime) && reservationCloseTime.before(bookedEventCloseTime)) {
                        result = false;
                    } else if ((reservationStartTime.before(reservationCloseTime)) &&
                            (reservationStartTime.after(bookedEventCloseTime) || (reservationCloseTime.before(bookedEventStartTime)))) {
                        // 회의실 예약 저장
                        result = true;
                    } else {
                        result = false;
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
//            result = false;
        }

        return result;
    }
}
