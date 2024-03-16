package com.project.ssm.search.controller;

import com.project.ssm.search.model.response.MemberSearchRes;
import com.project.ssm.search.service.MemberSearchService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
@AllArgsConstructor
public class MemberSearcController {
    private final MemberSearchService memberSearchService;

    @GetMapping("/member")
    public List<MemberSearchRes> searchMember(@RequestParam String keyword) {
        return memberSearchService.searchMembers(keyword);
    }
}
