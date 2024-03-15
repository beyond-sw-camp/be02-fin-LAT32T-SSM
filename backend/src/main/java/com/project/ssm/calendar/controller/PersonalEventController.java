package com.project.ssm.calendar.controller;


import com.project.ssm.calendar.model.entity.PersonalEvent;
import com.project.ssm.calendar.model.request.DeletePersonalEventReq;
import com.project.ssm.calendar.model.request.GetPersonalEventReq;
import com.project.ssm.calendar.model.request.PatchPersonalEventReq;
import com.project.ssm.calendar.model.request.PostPersonalEventReq;
import com.project.ssm.calendar.service.PersonalEventService;
import com.project.ssm.common.BaseResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/calendar/event")
@CrossOrigin("*")
public class PersonalEventController {
    private final PersonalEventService personalEventService;

    // 일정 등록
    @RequestMapping(method = RequestMethod.POST, value = "/create")
    public ResponseEntity createEvent(@RequestBody PostPersonalEventReq request){

        BaseResponse response = personalEventService.create(request);

        return ResponseEntity.ok(response);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String readTest() {
        String response = "[{\n" +
                "    \"_id\": 1,\n" +
                "    \"title\": \"거래처 미팅\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-07T09:30\",\n" +
                "    \"end\": \"2019-05-07T15:00\",\n" +
                "    \"type\": \"카테고리1\",\n" +
                "    \"username\": \"다현\",\n" +
                "    \"backgroundColor\": \"#D25565\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": false\n" +
                "  }, {\n" +
                "    \"_id\": 2,\n" +
                "    \"title\": \"치과예약\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-01T12:30\",\n" +
                "    \"end\": \"2019-05-01T15:30\",\n" +
                "    \"type\": \"카테고리1\",\n" +
                "    \"username\": \"나연\",\n" +
                "    \"backgroundColor\": \"#9775fa\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": false\n" +
                "  }, {\n" +
                "    \"_id\": 3,\n" +
                "    \"title\": \"철수 생일\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-12\",\n" +
                "    \"end\": \"2019-05-12\",\n" +
                "    \"type\": \"카테고리2\",\n" +
                "    \"username\": \"다현\",\n" +
                "    \"backgroundColor\": \"#ffa94d\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  }, {\n" +
                "    \"_id\": 4,\n" +
                "    \"title\": \"멜론 만기\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-06\",\n" +
                "    \"end\": \"2019-05-06\",\n" +
                "    \"type\": \"카테고리2\",\n" +
                "    \"username\": \"지효\",\n" +
                "    \"backgroundColor\": \"#74c0fc\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  }, {\n" +
                "    \"_id\": 5,\n" +
                "    \"title\": \"청약 입금\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-08\",\n" +
                "    \"end\": \"2019-05-08\",\n" +
                "    \"type\": \"카테고리3\",\n" +
                "    \"username\": \"지효\",\n" +
                "    \"backgroundColor\": \"#f06595\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  }, {\n" +
                "    \"_id\": 6,\n" +
                "    \"title\": \"카드값 납부\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-14\",\n" +
                "    \"end\": \"2019-05-14\",\n" +
                "    \"type\": \"카테고리2\",\n" +
                "    \"username\": \"사나\",\n" +
                "    \"backgroundColor\": \"#63e6be\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  }, {\n" +
                "    \"_id\": 7,\n" +
                "    \"title\": \"휴가\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-18\",\n" +
                "    \"end\": \"2019-05-20\",\n" +
                "    \"type\": \"카테고리4\",\n" +
                "    \"username\": \"사나\",\n" +
                "    \"backgroundColor\": \"#a9e34b\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  },{\n" +
                "    \"_id\": 8,\n" +
                "    \"title\": \"세차예약\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-24T09:00\",\n" +
                "    \"end\": \"2019-05-24T10:00\",\n" +
                "    \"type\": \"카테고리3\",\n" +
                "    \"username\": \"정연\",\n" +
                "    \"backgroundColor\": \"#4d638c\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": false\n" +
                "  },{\n" +
                "    \"_id\": 9,\n" +
                "    \"title\": \"출장\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-28\",\n" +
                "    \"end\": \"2019-05-31\",\n" +
                "    \"type\": \"카테고리3\",\n" +
                "    \"username\": \"정연\",\n" +
                "    \"backgroundColor\": \"#495057\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  },{\n" +
                "    \"_id\": 10,\n" +
                "    \"title\": \"접수 기간\",\n" +
                "    \"description\": \"Lorem ipsum dolor sit incid idunt ut Lorem ipsum sit.\",\n" +
                "    \"start\": \"2019-05-15\",\n" +
                "    \"end\": \"2019-05-22\",\n" +
                "    \"type\": \"카테고리2\",\n" +
                "    \"username\": \"다현\",\n" +
                "    \"backgroundColor\": \"#9775fa\",\n" +
                "    \"textColor\": \"#ffffff\",\n" +
                "    \"allDay\": true\n" +
                "  }]";
        return response;
    }
    // 연간 일정 조회
//    @RequestMapping(method = RequestMethod.GET, value = "/{year}")
//    public ResponseEntity getEventsByYear(@PathVariable int year, @RequestParam String memberId) {
//
//        BaseResponse response = personalEventService.findByYear(year,memberId);
//        // List<PersonalEvent> events = personalEventService.findByYear(year,memberId);
//        return ResponseEntity.ok(response);
//    }
//
//    // 일정 상세 조회
//    @RequestMapping(method = RequestMethod.GET, value = "/detail")
//    public ResponseEntity getEvent(@RequestBody GetPersonalEventReq request) {
//
//        BaseResponse response = personalEventService.findByEventIdx(request);
//        // List<PersonalEvent> events = personalEventService.findByYear(year,memberId);
//        return ResponseEntity.ok(response);
//    }
//
//    // 일정 수정
//    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
//    public ResponseEntity getEvent(@RequestBody PatchPersonalEventReq request) {
//
//        BaseResponse response = personalEventService.updateEvent(request);
//
//        return ResponseEntity.ok(response);
//    }
//
//    // 일정 삭제
//    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
//    public ResponseEntity getEvent(@RequestBody DeletePersonalEventReq request) {
//
//        BaseResponse response = personalEventService.deleteEvent(request);
//
//        return ResponseEntity.ok(response);
//    }

}