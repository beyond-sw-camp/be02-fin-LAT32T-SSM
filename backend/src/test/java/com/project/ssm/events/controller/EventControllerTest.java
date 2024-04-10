package com.project.ssm.events.controller;

import com.project.ssm.common.BaseResponse;
import com.project.ssm.config.security.SecurityConfig;
import com.project.ssm.events.model.response.GetEventRes;
import com.project.ssm.events.repository.EventRepository;
import com.project.ssm.events.service.EventService;
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
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.List;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(EventController.class)
@ContextConfiguration(classes = {SecurityConfig.class, EventController.class})
@AutoConfigureMockMvc
class EventControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private EventService eventService;

    @MockBean
    private CustomAccessDeniedHandler customAccessDeniedHandler;

    @MockBean
    private EventRepository eventRepository;

    @MockBean
    private MemberRepository memberRepository;


    @BeforeEach
    public void setUp() {
        mvc = MockMvcBuilders
                .webAppContextSetup(context)
                .apply(springSecurity())
                .build();
    }

    @Test
    @WithMockUser
    void listEvents() throws Exception {

        GetEventRes getEventRes = GetEventRes.builder()
                ._id(1L)
                .title("test")
                .description("test")
                .start("2024-04-10 00:00:00")
                .end("2024-04-30 00:00:00")
                .type("test")
                .username("test")
                .backgroundColor("#D25565")
                .textColor("#ffffff")
                .allDay(false)
                .build();

        BaseResponse<List<GetEventRes>> baseResponse = BaseResponse.successRes("EVENT_002", true, "일정 목록 조회 성공", List.of(getEventRes));


        //Given
        given(eventService.listEvents("2024-04-10", "2024-04-30")).willReturn(baseResponse);

        //When
        ResultActions result = mvc.perform(get("/calendar/event/list")
                .header("Authorization", "eyJhbGerawdciOiJIUzI1NiJ9.eyJzdWIiOiJtZW1iZXIwMSIsImV4cCI6MTYzNjQwNjQwMCwiaWF0IjoxNjM2NDAyNDAwfQ.1")
                .param("startDate", "2024-04-10")
                .param("endDate", "2024-04-30"));

        //Then
        result.andExpect(MockMvcResultMatchers.jsonPath("$.isSuccess").value(true));
    }
}