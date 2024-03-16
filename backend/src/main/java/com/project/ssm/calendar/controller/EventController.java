package com.project.ssm.calendar.controller;


import com.project.ssm.calendar.model.request.DeleteEventReq;
import com.project.ssm.calendar.model.request.PatchEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.calendar.model.response.GetEventRes;
import com.project.ssm.calendar.service.EventService;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar/event")
@CrossOrigin("*")
public class EventController {
    private final EventService eventService;

    // 일정 등록
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createEvent(@RequestBody PostEventReq request){

        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        BaseResponse response = eventService.create(member, request);

        return ResponseEntity.ok(response);
    }

    // 일정 상세 조회
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public ResponseEntity getEvent(@RequestParam Long eventIdx) {

        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        GetEventRes response = eventService.read(member, eventIdx);

        return ResponseEntity.ok(response);
    }

    // 연간 일정 조회
    @RequestMapping(method = RequestMethod.GET, value = "/{year}")
    public ResponseEntity listEvents(@PathVariable int year){

        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        List<GetEventRes> response = eventService.list(member, year);

        return ResponseEntity.ok().body(response);
    }

    // 일정 수정
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateEvent(@RequestBody PatchEventReq request) {

        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        BaseResponse response = eventService.update(member, request);

        return ResponseEntity.ok(response);
    }

    // 일정 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteEvent(@RequestParam Long eventIdx) {

        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());

        BaseResponse response = eventService.delete(member, eventIdx);

        return ResponseEntity.ok(response);
    }

//    @RequestMapping(method = RequestMethod.GET, value = "/test")
//    public String readTest() {
//        String response = "[{\n" +
//                "    \"_id\": 1,\n" +
//                "    \"title\": \"거래처 미팅\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-07T09:30\",\n" +
//                "    \"end\": \"2019-05-07T15:00\",\n" +
//                "    \"type\": \"카테고리1\",\n" +
//                "    \"username\": \"다현\",\n" +
//                "    \"backgroundColor\": \"#D25565\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": false\n" +
//                "  }, {\n" +
//                "    \"_id\": 2,\n" +
//                "    \"title\": \"치과예약\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-01T12:30\",\n" +
//                "    \"end\": \"2019-05-01T15:30\",\n" +
//                "    \"type\": \"카테고리1\",\n" +
//                "    \"username\": \"나연\",\n" +
//                "    \"backgroundColor\": \"#9775fa\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": false\n" +
//                "  }, {\n" +
//                "    \"_id\": 3,\n" +
//                "    \"title\": \"철수 생일\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-12\",\n" +
//                "    \"end\": \"2019-05-12\",\n" +
//                "    \"type\": \"카테고리2\",\n" +
//                "    \"username\": \"다현\",\n" +
//                "    \"backgroundColor\": \"#ffa94d\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  }, {\n" +
//                "    \"_id\": 4,\n" +
//                "    \"title\": \"멜론 만기\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-06\",\n" +
//                "    \"end\": \"2019-05-06\",\n" +
//                "    \"type\": \"카테고리2\",\n" +
//                "    \"username\": \"지효\",\n" +
//                "    \"backgroundColor\": \"#74c0fc\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  }, {\n" +
//                "    \"_id\": 5,\n" +
//                "    \"title\": \"청약 입금\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-08\",\n" +
//                "    \"end\": \"2019-05-08\",\n" +
//                "    \"type\": \"카테고리3\",\n" +
//                "    \"username\": \"지효\",\n" +
//                "    \"backgroundColor\": \"#f06595\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  }, {\n" +
//                "    \"_id\": 6,\n" +
//                "    \"title\": \"카드값 납부\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-14\",\n" +
//                "    \"end\": \"2019-05-14\",\n" +
//                "    \"type\": \"카테고리2\",\n" +
//                "    \"username\": \"사나\",\n" +
//                "    \"backgroundColor\": \"#63e6be\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  }, {\n" +
//                "    \"_id\": 7,\n" +
//                "    \"title\": \"휴가\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-18\",\n" +
//                "    \"end\": \"2019-05-20\",\n" +
//                "    \"type\": \"카테고리4\",\n" +
//                "    \"username\": \"사나\",\n" +
//                "    \"backgroundColor\": \"#a9e34b\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  },{\n" +
//                "    \"_id\": 8,\n" +
//                "    \"title\": \"세차예약\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-24T09:00\",\n" +
//                "    \"end\": \"2019-05-24T10:00\",\n" +
//                "    \"type\": \"카테고리3\",\n" +
//                "    \"username\": \"정연\",\n" +
//                "    \"backgroundColor\": \"#4d638c\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": false\n" +
//                "  },{\n" +
//                "    \"_id\": 9,\n" +
//                "    \"title\": \"출장\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-28\",\n" +
//                "    \"end\": \"2019-05-31\",\n" +
//                "    \"type\": \"카테고리3\",\n" +
//                "    \"username\": \"정연\",\n" +
//                "    \"backgroundColor\": \"#495057\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  },{\n" +
//                "    \"_id\": 10,\n" +
//                "    \"title\": \"접수 기간\",\n" +
//                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
//                "    \"start\": \"2019-05-15\",\n" +
//                "    \"end\": \"2019-05-22\",\n" +
//                "    \"type\": \"카테고리2\",\n" +
//                "    \"username\": \"다현\",\n" +
//                "    \"backgroundColor\": \"#9775fa\",\n" +
//                "    \"textColor\": \"#ffffff\",\n" +
//                "    \"allDay\": true\n" +
//                "  }]";
//        return response;
//    }

}