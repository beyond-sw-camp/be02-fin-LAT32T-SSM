package com.project.ssm.chatRoom.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ssm.chat.controller.ChatController;
import com.project.ssm.chat.model.entity.ChatRoom;
import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.request.PostCreateRoomReq;
import com.project.ssm.chat.model.response.PostCreateRoomRes;
import com.project.ssm.chat.repository.MessageRepository;
import com.project.ssm.chat.service.MessageService;
import com.project.ssm.chat.service.RoomService;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.meetingroom.controller.MeetingRoomController;
import com.project.ssm.member.config.SecurityConfig;
import com.project.ssm.member.exception.security.CustomAccessDeniedHandler;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import com.project.ssm.member.service.MemberService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ExtendWith(SpringExtension.class)
@WebMvcTest(value = MeetingRoomController.class)
@ContextConfiguration(classes = { SecurityConfig.class, ChatController.class})
public class ChatRoomControllerTest {
    @Autowired
    MockMvc mvc;

    @MockBean
    private RoomService chatRoomService;

    @Test
    void chatRoomController_create_success() throws Exception {
        Member member = Member.builder().memberId("member01").memberPw("qwer1234").memberName("test01").department("IT").position("manager").build();

        ChatRoom chatRoom = ChatRoom.createRoom("test");

        PostCreateRoomRes result = PostCreateRoomRes.buildRoomRes(chatRoom.getChatRoomName(), chatRoom.getChatRoomId());

        // given
        given(chatRoomService.createRoom(any(PostCreateRoomReq.class), any(Member.class)))
                .willReturn(BaseResponse.successRes("CHATTING_001", true, "채팅방이 생성되었습니다.", result));

        // when
        List<String> memberIdList = new ArrayList<>();
        memberIdList.add("member01");
        memberIdList.add("member02");
        PostCreateRoomReq request = new PostCreateRoomReq();
        request.setChatRoomName("test");
        request.setMemberId(memberIdList);

        // then
        ObjectMapper mapper = new ObjectMapper();
        String content = mapper.writeValueAsString(request);
        System.out.println(content);
        mvc.perform(post("/chat/room/create")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(content))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.message").value("채팅방이 생성되었습니다."))
                .andExpect(jsonPath("$.isSuccess").value(true));
    }
}
