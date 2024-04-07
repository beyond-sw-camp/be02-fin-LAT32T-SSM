package com.project.ssm.member.controller;


import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.request.*;
import com.project.ssm.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;

@RestController
@RequestMapping("/member")
@RequiredArgsConstructor
@CrossOrigin("*")
public class MemberController {
    private final MemberService memberService;

    @RequestMapping(method = RequestMethod.POST, value = "/signup")
    public ResponseEntity signup(
            @RequestPart(value = "member") @Valid PostMemberSignupReq req,
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage) {
        return ResponseEntity.ok().body(memberService.signup(req, profileImage));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/login")
    public ResponseEntity login(@RequestBody @Valid PostMemberLoginReq req) {
        return ResponseEntity.ok().body(memberService.login(req));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/check/id")
    public ResponseEntity checkId(@RequestBody @Valid GetMemberCheckIdReq req) {
        return ResponseEntity.ok().body(memberService.checkId(req));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/update")
    public ResponseEntity updatePassword(
            @RequestPart(value = "member") @Valid PatchMemberUpdatePasswordReq req,
            @RequestPart(value = "profileImage", required = false) MultipartFile profileImage) {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(memberService.updatePassword(member, req, profileImage));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/delete")
    public ResponseEntity delete() {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(memberService.delete(member));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/profile/add")
    public ResponseEntity profileAdd() {
        return ResponseEntity.ok().body("ok");
    }

    @RequestMapping(method = RequestMethod.GET, value = "/read")
    public ResponseEntity memberRead() {
        return ResponseEntity.ok().body(memberService.read());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/profile")
    public ResponseEntity getProfileImage(@RequestBody GetProfileImageReq getProfileImageReq) {
        return ResponseEntity.ok().body(memberService.getMemberProfile(getProfileImageReq));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/chatroommembers")
    public ResponseEntity getChatRoomMembers(@RequestParam(value = "chatRoomName") String chatRoomName ){
        return ResponseEntity.ok().body(memberService.getChatRoomMembers(chatRoomName));
    }
}
