package com.project.ssm.notification;

import com.project.ssm.events.model.entity.Event;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static com.project.ssm.notification.NotificationController.sendAlarmToClients;

@Service
@RequiredArgsConstructor
public class NotificationService {

    private final EventRepository eventRepository;

    /**
     *     "2024-03-16 16:48",
     *     "2024-03-13 17:16",
     *     "2024-03-13 17:16",
     *     "2024-03-20 17:18"
     * */
    public List<Date> memberEventRead() {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        List<Event> eventsByMemberIdx = eventRepository.findEventsByMemberIdx((member.getMemberIdx()));
        List<Date> startList = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date currentDate = new Date();
        for (Event event : eventsByMemberIdx) {
            try {
                Date parse = sdf.parse(event.getStartedAt());

                // parse와 currentDate 사이의 밀리초 단위 차이 계산
                long difference = parse.getTime() - currentDate.getTime();

                // 차이가 10분 이내인 경우 startList에 추가
                if (difference >= 0 && difference <= 600000) {
                    startList.add(parse);
                    sendAlarmToClients(member.getMemberId(), event.getTitle() + " 일정이 곧 시작예정입니다.");
                }

            } catch (ParseException e) {
                throw new RuntimeException(e);
            }
        }
        return startList;
    }
}
