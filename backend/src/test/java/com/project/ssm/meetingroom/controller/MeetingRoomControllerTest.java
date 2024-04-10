package com.project.ssm.meetingroom.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.config.security.SecurityConfig;
import com.project.ssm.meetingroom.model.entity.MeetingRoom;
import com.project.ssm.meetingroom.model.response.*;
import com.project.ssm.meetingroom.repository.MeetingRoomRepository;
import com.project.ssm.meetingroom.service.MeetingRoomService;
import com.project.ssm.member.exception.security.CustomAccessDeniedHandler;
import com.project.ssm.member.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(MeetingRoomController.class)
@ContextConfiguration(classes = {SecurityConfig.class, MeetingRoomController.class})
@AutoConfigureMockMvc
class MeetingRoomControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private MeetingRoomService meetingRoomService;

    @MockBean
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @MockBean
    private MemberRepository memberRepository;

    @MockBean
    private MeetingRoomRepository meetingRoomRepository;

    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser
    void getAllMeetingRooms() throws Exception {

        MeetingRoom meetingRoom = MeetingRoom.builder()
                .meetingRoomIdx(1L)
                .meetingRoomName("회의실1")
                .meetingRoomCapacity(10)
                .isAvailable(true)
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")))
                .build();

        MeetingRoomListRes meetingRoomListRes = MeetingRoomListRes.buildMeetingRoomListRes(meetingRoom);

        BaseResponse<List<MeetingRoomListRes>> response = BaseResponse.successRes("MEETING_000", true, "회의실 전체 조회", List.of(meetingRoomListRes));


        //Given
        given(meetingRoomService.getAllMeetingRooms()).willReturn(response);

        //When
        ResultActions result = mvc.perform(get("/meetingroom/list")
                .contentType(MediaType.APPLICATION_JSON));

        //Then
        result.andExpect(status().isOk()).andExpect(jsonPath("$.isSuccess").value(true));


    }
}