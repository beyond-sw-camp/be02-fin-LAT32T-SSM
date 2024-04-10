package com.project.ssm.chat.controller;

import com.project.ssm.chat.model.request.PatchUpdateRoomReq;
import com.project.ssm.chat.model.request.PostCreateRoomReq;
import com.project.ssm.chat.service.RoomService;
import com.project.ssm.member.model.Member;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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

    @RequestMapping(method = RequestMethod.GET, value = "/room/{chatRoomId}")
    public ResponseEntity<Object> getRoomInfo(@PathVariable String chatRoomId) {
        return ResponseEntity.ok().body(roomService.getRoomInfo(chatRoomId));
    }

    @RequestMapping(method = RequestMethod.GET, value = "/room/chatlist")
    public ResponseEntity<Object> getChatList(@RequestHeader(value = "Authorization") String token, String chatRoomId, Integer page, Integer size) {
        return ResponseEntity.ok().body(roomService.getChatList(token, chatRoomId, page, size));
    }

    @RequestMapping(method = RequestMethod.POST, value = "/room/create")
    public ResponseEntity<Object> createRoom(@RequestBody @Valid PostCreateRoomReq postCreateRoomReq) {
        Member member = (Member) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return ResponseEntity.ok().body(roomService.createRoom(postCreateRoomReq, member));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/update")
    public ResponseEntity<Object> updateRoom(@RequestBody @Valid PatchUpdateRoomReq patchUpdateRoomReq) {
        return ResponseEntity.ok().body(roomService.updateRoom(patchUpdateRoomReq));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/out/{chatRoomId}")
    public ResponseEntity<Object> outRoom(@RequestHeader(value = "Authorization") String token, @PathVariable String chatRoomId) {
        return ResponseEntity.ok().body(roomService.outRoom(token, chatRoomId));
    }

    @RequestMapping(method = RequestMethod.PATCH, value = "/room/delete/{chatRoomId}")
    public ResponseEntity<Object> deleteRoom(@PathVariable String chatRoomId) {
        return ResponseEntity.ok().body(roomService.deleteChatRoom(chatRoomId));
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/message/delete/{messageIdx}")
    public ResponseEntity<Object> deleteMessage(@RequestHeader(value = "Authorization") String token, @PathVariable Long messageIdx) {
        return ResponseEntity.ok().body(roomService.deleteMessage(token, messageIdx));
    }
}
