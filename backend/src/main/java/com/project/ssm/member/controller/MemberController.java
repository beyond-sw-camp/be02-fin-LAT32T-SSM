package com.project.ssm.member.controller;


import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.request.GetMemberCheckIdReq;
import com.project.ssm.member.model.request.PatchMemberUpdatePasswordReq;
import com.project.ssm.member.model.request.PostMemberLoginReq;
import com.project.ssm.member.model.request.PostMemberSignupReq;
import com.project.ssm.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberController {
    private final MemberService memberService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(@RequestBody @Valid PostMemberSignupReq req) {
        return ResponseEntity.ok().body(memberService.signup(req));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody @Valid PostMemberLoginReq req) {
        return ResponseEntity.ok().body(memberService.login(req));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/check/id")
    public ResponseEntity checkId(@RequestBody @Valid GetMemberCheckIdReq req) {
        return ResponseEntity.ok().body(memberService.checkId(req));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updatePassword(@RequestBody @Valid PatchMemberUpdatePasswordReq req) {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(memberService.updatePassword(member, req));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/delete")
    public ResponseEntity delete() {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(memberService.delete(member));
    }
}
