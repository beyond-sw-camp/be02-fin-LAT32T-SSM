package com.project.ssm.chat.controller;

import com.project.ssm.chat.model.request.PatchUpdateRoomReq;
import com.project.ssm.chat.model.request.PostCreateRoomReq;
import com.project.ssm.chat.service.RoomService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
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

    @RequestMapping(method = RequestMethod.GET, value = "/room/{roomId}")
    public ResponseEntity<Object> getRoomInfo(@PathVariable String roomId) {
        return ResponseEntity.ok().body(roomService.getRoomInfo(roomId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/room/chatlist")
    public ResponseEntity<Object> getChatList(@RequestHeader(value = "Authorization") String token, String chatRoomId, Integer page, Integer size) {
        return ResponseEntity.ok().body(roomService.getChatList(token, chatRoomId, page, size));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/room/create")
    public ResponseEntity<Object> createRoom(@RequestBody PostCreateRoomReq postCreateRoomReq) {
        return ResponseEntity.ok().body(roomService.createRoom(postCreateRoomReq));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/update")
    public ResponseEntity<Object> updateRoom(@RequestBody PatchUpdateRoomReq patchUpdateRoomReq) {
        return ResponseEntity.ok().body(roomService.updateRoom(patchUpdateRoomReq));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/out/{chatRoomIdx}")
    public ResponseEntity<Object> outRoom(@RequestHeader(value = "Authorization") String token, @PathVariable String chatRoomIdx) {
        return ResponseEntity.ok().body(roomService.outRoom(token, chatRoomIdx));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/delete/{chatRoomIdx}")
    public ResponseEntity<Object> deleteRoom(@PathVariable String chatRoomIdx) {
        return ResponseEntity.ok().body(roomService.deleteChatRoom(chatRoomIdx));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/message/delete/{messageIdx}")
    public ResponseEntity<Object> deleteMessage(@RequestHeader(value = "Authorization") String token, @PathVariable Long messageIdx) {
        return ResponseEntity.ok().body(roomService.deleteMessage(token, messageIdx));
    }
}
