package com.project.ssm.events.utils;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.member.exception.MemberNotFoundException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Configuration
@RequiredArgsConstructor
public class EventsOfDate {

    private final EventRepository eventRepository;
    private final MemberRepository memberRepository;

    public List<Event> findEventsOfDate(String date, Long memberIdx) {
        // date = "2024-03-28"
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

        Optional<Member> result = memberRepository.findMemberByMemberIdx(memberIdx);
        List<Event> eventsOfMember = eventRepository.findEventsByMemberIdx(memberIdx);
        List<Event> eventList = new ArrayList<>();
        if (result.isEmpty()) {
            throw MemberNotFoundException.forMemberIdx(memberIdx);
        } else {
            for (Event event : eventsOfMember) {
                try {
                    // 시작일
                    Date eventStartDate = formatter.parse(event.getStartedAt().substring(0, 10));
                    // 종료일
                    Date eventCloseDate = formatter.parse(event.getClosedAt().substring(0, 10));
                    // 주어진 날짜
                    Date givenDate = formatter.parse(date);
                    // 시작일이 주어진 날짜와 같거나// 종료일이 주어진 날짜와 같거나// 시작일이 주어진 날짜보다 이전이고 종료일이 주어진 날짜보다 이후인 경우
                    if ((eventStartDate.equals(givenDate)) || (eventCloseDate.equals(givenDate)) || ((eventStartDate.before(givenDate) && (eventCloseDate.after(givenDate))))){
                        eventList.add(event);
                    }
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return eventList;
    }
}
