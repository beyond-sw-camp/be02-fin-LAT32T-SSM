package com.project.ssm.chat.controller;

import com.project.ssm.chat.model.response.GetRoomListRes;
import com.project.ssm.chat.repository.ChatRoomRepository;
import com.project.ssm.chat.service.RoomService;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.config.security.SecurityConfig;
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
import java.util.UUID;

import static org.mockito.BDDMockito.given;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@ExtendWith(MockitoExtension.class)
@WebMvcTest(ChatRoomController.class)
@ContextConfiguration(classes = {SecurityConfig.class, ChatRoomController.class})
@AutoConfigureMockMvc
public class ChatRoomControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private RoomService roomService;

    @MockBean
    private ChatRoomRepository chatRoomRepository;

    @MockBean
    private CustomAccessDeniedHandler customAccessDeniedHandler;

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
    void test_getRoomList_success() throws Exception {

        String uuid = UUID.randomUUID().toString();

        GetRoomListRes getRoomListRes = GetRoomListRes.builder()
                .chatRoomId(uuid)
                .chatRoomName("room1")
                .build();

        BaseResponse<List<GetRoomListRes>> res = BaseResponse.successRes("CHATROOM_001", true, "채팅방 목록 조회 성공", List.of(getRoomListRes));

        // Given
        given(roomService.getRoomList("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZW1iZXIwMSIsImV4cCI6MTYzNjQwNjQwMCwiaWF0IjoxNjM2NDAyNDAwfQ.1")).willReturn(res);


        // When
        ResultActions result = mvc.perform(get("/chat/rooms")
                .header("Authorization", "eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZW1iZXIwMSIsImV4cCI6MTYzNjQwNjQwMCwiaWF0IjoxNjM2NDAyNDAwfQ.1"));


        // Then
        result.andExpect(MockMvcResultMatchers.jsonPath("$.isSuccess").value(true));

    }

}
