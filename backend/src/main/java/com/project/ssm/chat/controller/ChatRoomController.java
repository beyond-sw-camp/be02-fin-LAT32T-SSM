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
    public ResponseEntity<Object> getRoomList(@RequestHeader(value = "Authorization") String token) {
        return ResponseEntity.ok().body(roomService.getRoomList(token));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/room/create")
    public ResponseEntity<Object> createRoom(@RequestBody PostCreateRoomReq postCreateRoomReq) {
        return ResponseEntity.ok().body(roomService.createRoom(postCreateRoomReq));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/room/{roomId}")
    public ResponseEntity<Object> getRoomInfo(@PathVariable String roomId) {
        return ResponseEntity.ok().body(roomService.getRoomInfo(roomId));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/update")
    public void updateRoom() {

    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/delete")
    public void deleteRoom() {

    }
}
