package com.project.ssm.member.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.common.error.ErrorCode;
import com.project.ssm.config.security.SecurityConfig;
import com.project.ssm.member.exception.MemberNotFoundException;
import com.project.ssm.member.exception.security.CustomAccessDeniedHandler;
import com.project.ssm.member.model.request.PostMemberLoginReq;
import com.project.ssm.member.model.request.PostMemberSignupReq;
import com.project.ssm.member.model.response.PostMemberLoginRes;
import com.project.ssm.member.model.response.PostMemberSignupRes;
import com.project.ssm.member.repository.MemberRepository;
import com.project.ssm.member.service.MemberService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.when;
import static org.springframework.security.test.web.servlet.setup.SecurityMockMvcConfigurers.springSecurity;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ExtendWith(SpringExtension.class)
@WebMvcTest(MemberController.class)
@ContextConfiguration(classes = {SecurityConfig.class, MemberController.class})
@AutoConfigureMockMvc
public class MemberControllerTest {

    @Autowired
    MockMvc mvc;

    @Autowired
    private WebApplicationContext context;

    @MockBean
    private MemberService memberService;

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
    void test_signup_success() throws Exception {

        PostMemberSignupRes res = PostMemberSignupRes.builder()
                .memberIdx(1L)
                .memberId("member01")
                .memberName("test")
                .build();

        BaseResponse<PostMemberSignupRes> baseResponse = BaseResponse.successRes("MEMBER_001", true, "회원이 등록되었습니다.", res);

        // Given
        PostMemberSignupReq req = PostMemberSignupReq.builder()
                .memberId("member01")
                .password("qwer1234")
                .memberName("test")
                .department("IT")
                .position("manager")
                .build();

        MockMultipartFile profileImage = new MockMultipartFile("profileImage", "test.jpg", "image/jpeg", "test".getBytes());

        given(memberService.signup(any(PostMemberSignupReq.class), any(MockMultipartFile.class))).willReturn(baseResponse);

        // When
        ResultActions result = mvc.perform(multipart("/member/signup")
                .file(new MockMultipartFile("member", "", "application/json", new ObjectMapper().writeValueAsString(req).getBytes()))
                .file(profileImage)
                .contentType(MediaType.MULTIPART_FORM_DATA)
                .accept(MediaType.APPLICATION_JSON));

        // Then
        result.andExpect(status().isOk()).andExpect(MockMvcResultMatchers.jsonPath("$.isSuccess").value(true));

    }

    @Test
    @WithMockUser
    void test_login_success() throws Exception {

        PostMemberLoginRes res = PostMemberLoginRes.builder()
                .token("eyJhbGciOiJIUzI1NiJ9.eyJzdWIiOiJtZW1iZXIwMSIsImV4cCI6MTYzNjQwNjQwMCwiaWF0IjoxNjM2NDAyNDAwfQ.1")
                .build();

        BaseResponse<PostMemberLoginRes> baseResponse = BaseResponse.successRes("MEMBER_011", true, "로그인에 성공하였습니다.", res);


        // Given
        PostMemberLoginReq req = PostMemberLoginReq.builder()
                .memberId("member01")
                .password("qwer1234")
                .build();

        given(memberService.login(any(PostMemberLoginReq.class))).willReturn(baseResponse);

        // When
        ResultActions result = mvc.perform(post("/member/login")
                        .content(new ObjectMapper().writeValueAsString(req))
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());

        // Then
        result.andExpect(MockMvcResultMatchers.jsonPath("$.isSuccess").value(true));
    }

//    @Test
//    void test_login_fail() throws Exception {
//
//        // Given
//        PostMemberLoginReq req = PostMemberLoginReq.builder()
//                .memberId("member0123")
//                .password("qwer1234")
//                .build();
//
//        // When
//        when(memberService.login(any(PostMemberLoginReq.class))).thenThrow(MemberNotFoundException.forMemberId(req.getMemberId()));
//
//        ResultActions result = mvc.perform(post("/member/login")
//                        .content(new ObjectMapper().writeValueAsString(req))
//                        .contentType(MediaType.APPLICATION_JSON))
//                .andExpect(status().isUnauthorized());
//
//        // Then
//        result.andExpect(MockMvcResultMatchers.jsonPath("$.isSuccess").value(false));
//    }
}
