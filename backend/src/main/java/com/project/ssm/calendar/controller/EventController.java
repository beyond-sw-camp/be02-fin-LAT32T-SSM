package com.project.ssm.calendar.controller;


import com.project.ssm.calendar.model.request.DeleteEventReq;
import com.project.ssm.calendar.model.request.PatchEventReq;
import com.project.ssm.calendar.model.request.PostEventReq;
import com.project.ssm.calendar.model.response.GetEventRes;
import com.project.ssm.calendar.service.EventService;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
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
        return ResponseEntity.ok().body(eventService.create(member, request));
    }

    // 일정 상세 조회
    @RequestMapping(method = RequestMethod.GET, value = "/detail")
    public ResponseEntity getEvent(@RequestParam Long eventIdx) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.read(member, eventIdx));
    }

    // 연간 일정 조회
    @RequestMapping(method = RequestMethod.GET, value = "/{year}")
    public ResponseEntity listEvents(@PathVariable int year){
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.list(member, year));
    }

    // 일정 수정
    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updateEvent(@RequestBody PatchEventReq request) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.update(member, request));
    }

    // 일정 삭제
    @RequestMapping(method = RequestMethod.DELETE, value = "/delete")
    public ResponseEntity deleteEvent(@RequestParam Long eventIdx) {
        Member member = ((Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        return ResponseEntity.ok().body(eventService.delete(member, eventIdx));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/test")
    public String readTest() {
        String response
                =
//                "[{\n" +
//                "        \"_id\": 1,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": null,\n" +
//                "        \"start\": \"2024-03-19T22:16\",\n" +
//                "        \"end\": \"2024-03-22T23:16\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                        "        \"backgroundColor\": \"#D25565\",\n" +
//                        "        \"textColor\": \"#ffffff\",\n" +
//                        "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 2,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": null,\n" +
//                "        \"start\": \"2024-03-26T22:26\",\n" +
//                "        \"end\": \"2024-03-29T23:26\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                        "        \"backgroundColor\": \"#D25565\",\n" +
//                        "        \"textColor\": \"#ffffff\",\n" +
//                        "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 3,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": null,\n" +
//                "        \"start\": \"2024-03-12T22:32\",\n" +
//                "        \"end\": \"2024-03-15T23:32\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                        "        \"backgroundColor\": \"#D25565\",\n" +
//                        "        \"textColor\": \"#ffffff\",\n" +
//                        "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 4,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": \"asdfg\",\n" +
//                "        \"start\": \"2024-03-11T22:40\",\n" +
//                "        \"end\": \"2024-03-13T23:40\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 5,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": \"jkljl;\",\n" +
//                "        \"start\": \"2024-03-11\",\n" +
//                "        \"end\": \"2024-03-15\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": true\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 6,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": \"123456\",\n" +
//                "        \"start\": \"2024-03-11T22:45\",\n" +
//                "        \"end\": \"2024-03-14T23:45\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 7,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": \"ㅁㄴㅇㅀ\",\n" +
//                "        \"start\": \"2024-03-11T23:46\",\n" +
//                "        \"end\": \"2024-03-15T00:46\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 8,\n" +
//                "        \"title\": \"ㅏㅏ\",\n" +
//                "        \"description\": \"ㅗㅓㅏㅣ\",\n" +
//                "        \"start\": \"2024-03-12T23:51\",\n" +
//                "        \"end\": \"2024-03-15T00:51\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 9,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": \"qwer\",\n" +
//                "        \"start\": \"2024-03-11T04:01\",\n" +
//                "        \"end\": \"2024-03-14T05:01\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 10,\n" +
//                "        \"title\": \"meeting006\",\n" +
//                "        \"description\": \"content06\",\n" +
//                "        \"start\": \"2024-03-20T09:30\",\n" +
//                "        \"end\": \"2024-03-22T15:00\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 11,\n" +
//                "        \"title\": \"meeting01\",\n" +
//                "        \"description\": \"asdf\",\n" +
//                "        \"start\": \"2024-03-26T04:19\",\n" +
//                "        \"end\": \"2024-03-28T05:19\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 12,\n" +
//                "        \"title\": \"meeting02\",\n" +
//                "        \"description\": \"qwer\",\n" +
//                "        \"start\": \"2024-04-03T04:21\",\n" +
//                "        \"end\": \"2024-04-05T05:21\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 13,\n" +
//                "        \"title\": \"ㅘㅗㅓㅏㅘㅓ\",\n" +
//                "        \"description\": \"ㄹ호ㅓㅏㅣ호ㅓㅏㅣ\",\n" +
//                "        \"start\": \"2024-03-18T12:35\",\n" +
//                "        \"end\": \"2024-03-21T13:35\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 14,\n" +
//                "        \"title\": \"dd\",\n" +
//                "        \"description\": \"ㅇㄻㄹ\",\n" +
//                "        \"start\": \"2024-03-26T12:36\",\n" +
//                "        \"end\": \"2024-03-28T13:36\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 15,\n" +
//                "        \"title\": \"ㅇㅇㅇ\",\n" +
//                "        \"description\": \"ㅇㅇㅇㅇㅇ\",\n" +
//                "        \"start\": \"2024-04-02T12:40\",\n" +
//                "        \"end\": \"2024-04-04T13:40\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    },\n" +
//                "    {\n" +
//                "        \"_id\": 16,\n" +
//                "        \"title\": \"ㄴㅇㅀㅇㄹ\",\n" +
//                "        \"description\": \"ㅇㄹ호ㅓㄹ호ㅓㅏ\",\n" +
//                "        \"start\": \"2024-03-12T12:41\",\n" +
//                "        \"end\": \"2024-03-14T13:41\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "  }]";



//                "[\n" +
//                "    {\n" +
//                "        \"_id\": 10,\n" +
//                "        \"title\": \"meeting006\",\n" +
//                "        \"description\": \"content06\",\n" +
//                "        \"start\": \"2024-03-20T09:30\",\n" +
//                "        \"end\": \"2024-03-22T15:00\",\n" +
//                "        \"type\": \"카테고리4\",\n" +
//                "        \"username\": \"사나\",\n" +
//                "        \"backgroundColor\": \"#D25565\",\n" +
//                "        \"textColor\": \"#ffffff\",\n" +
//                "        \"allDay\": false\n" +
//                "    }\n" +
//                "]";
                "[{\n" +
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

}