package com.project.ssm.member.controller;


import com.project.ssm.member.model.request.PostSignupReq;
import com.project.ssm.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberController {
    private final MemberService memberService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(@RequestBody PostSignupReq req) {

        return ResponseEntity.ok().body(memberService.signup(req));
    }
}
