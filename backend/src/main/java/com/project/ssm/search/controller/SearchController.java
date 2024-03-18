package com.project.ssm.search.controller;

import com.project.ssm.search.service.SearchService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin("*")
@RestController
@RequestMapping("/search")
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @RequestMapping(method = RequestMethod.GET, value = "/member/{keyword}")
    public ResponseEntity<Object> searchMember(@PathVariable String keyword) {
        return ResponseEntity.ok().body(searchService.searchMembers(keyword));
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/chat/message")
//    public ResponseEntity<Object> chatSearch(@RequestBody ChatSearchReq chatSearchReq) {
//        return ResponseEntity.ok().body(searchService.searchMessage(chatSearchReq));
//    }
}
