package com.project.ssm.member.controller;


import com.project.ssm.member.model.request.PostMemberLoginReq;
import com.project.ssm.member.model.request.PostMemberSignupReq;
import com.project.ssm.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberController {
    private final MemberService memberService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(@RequestBody PostMemberSignupReq req) {

        return ResponseEntity.ok().body(memberService.signup(req));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody @Valid PostMemberLoginReq req) {

        return ResponseEntity.ok().body(memberService.login(req));
    }
}
