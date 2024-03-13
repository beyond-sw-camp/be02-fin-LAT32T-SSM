package com.project.ssm.chat.controller;

import com.project.ssm.chat.model.request.PostCreateRoomReq;
import com.project.ssm.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/chat")
@CrossOrigin("*")
@Slf4j
public class ChatRoomController {

    private final RoomService roomService;

    @RequestMapping(method = RequestMethod.GET, value = "/rooms")
    public ResponseEntity<Object> getRoomList() {
        return ResponseEntity.ok().body(roomService.getRoomList());
    }

    @RequestMapping(method = RequestMethod.POST, value = "/room/create")
    public ResponseEntity<Object> createRoom(@RequestBody PostCreateRoomReq postCreateRoomReq) {
        return ResponseEntity.ok().body(roomService.createRoom(postCreateRoomReq));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/room/{roomIdx}")
    public ResponseEntity<Object> getRoomInfo(@PathVariable String roomIdx) {
        return ResponseEntity.ok().body(roomService.getRoomInfo(roomIdx));
    }
}
