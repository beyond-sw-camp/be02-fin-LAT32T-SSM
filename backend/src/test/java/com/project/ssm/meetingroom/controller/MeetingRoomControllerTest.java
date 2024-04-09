package com.project.ssm.meetingroom.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.meetingroom.model.request.MeetingRoomAddReq;
import com.project.ssm.meetingroom.model.response.MeetingRoomAddResult;
import com.project.ssm.meetingroom.model.response.MeetingSelectRes;
import com.project.ssm.meetingroom.model.response.GetMeetingRoomSelectRes;
import com.project.ssm.meetingroom.model.response.MeetingSelectResReservation;
import com.project.ssm.meetingroom.service.MeetingRoomService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(MeetingRoomController.class)
@ContextConfiguration(classes = {MeetingRoomController.class})
class MeetingRoomControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private MeetingRoomService meetingRoomService;

    // Spring Security 우회를 위해 SecurityFilterChain을 모의 빈 처리
    @MockBean
    private SecurityFilterChain securityFilterChain;


//    @Test
//    void MeetingRoomController_addMeetingRoom_success() throws Exception {
//        MeetingRoomAddResult result = MeetingRoomAddResult.builder()
//                .idx(1L)
//                .roomName("제 1 회의실")
//                .build();
//
//        MeetingRoomAddReq request = MeetingRoomAddReq.builder()
//                .roomName("제 1 회의실")
//                .roomCapacity(10)
//                .build();
//
//        given(meetingRoomService.createMeetingRoom(any())).willReturn(result);
//
//
//        ObjectMapper mapper = new ObjectMapper();
//        String content = mapper.writeValueAsString(request);
//
//        mvc.perform(post("/meetingroom/add")
//                        .contentType(MediaType.APPLICATION_JSON)
//                        .content(content))
//                .andExpect(status().isOk())
//                .andExpect(jsonPath("$.isSuccess").value(true))
//                .andExpect(jsonPath("$.code").value("ROOM_001"))
//                .andExpect(jsonPath("$.message").value("새로운 회의실이 생성되었습니다."))
//                .andExpect(jsonPath("$.result.idx").value(result.getIdx()))
//                .andExpect(jsonPath("$.result.roomName").value(result.getRoomName()))
//                .andExpect(jsonPath("$.message").value("새로운 회의실이 생성되었습니다."));
//    }


    @Test
    void MeetingRoomController_getMeetingRoom_success() throws Exception {
        DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String createdAt = LocalDateTime.now().format(customFormatter);
        String startedAt = LocalDateTime.now().plusHours(5).format(customFormatter);
        String closedAt = LocalDateTime.now().plusHours(10).format(customFormatter);


        MeetingSelectResReservation reservation = MeetingSelectResReservation.builder()
                .eventIdx(1L)
                .createdAt(createdAt)
                .startedAt(startedAt)
                .closedAt(closedAt)
                .build();
        GetMeetingRoomSelectRes roomSelectResult = GetMeetingRoomSelectRes.builder()
                .roomIdx(1L)
                .roomName("제 1 회의실")
                .roomCapacity(10)
                .reservations(Collections.singletonList(reservation))
                .build();

//        given(meetingRoomService.getMeetingRoom(any())).willReturn(BaseResponse.successRes("MEETING_000", true, "회의실 예약 조회", roomSelectResult));


        mvc.perform(get("/meetingroom/select/{meetingRoomIdx}", 1)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.isSuccess").value(true))
                .andExpect(jsonPath("$.code").value("MEETING_000"))
                .andExpect(jsonPath("$.message").value("회의실 예약 조회"))
                .andExpect(jsonPath("$.result.roomIdx").value(1))
                .andExpect(jsonPath("$.result.roomName").value("제 1 회의실"))
                .andExpect(jsonPath("$.result.roomCapacity").value(10));
    }



    @Test
    void MeetingRoomController_getAllMeetingRoom_success() throws Exception {

    }

    @Test
    void MeetingRoomController_deleteMeetingRoom_success() throws Exception {

    }
}