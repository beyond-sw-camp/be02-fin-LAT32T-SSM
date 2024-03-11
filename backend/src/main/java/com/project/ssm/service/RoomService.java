package com.project.ssm.service;

import com.project.ssm.model.entity.ChatRoom;
import com.project.ssm.model.request.PostCreateRoomReq;
import com.project.ssm.model.response.GetRoomInfoRes;
import com.project.ssm.model.response.GetRoomListRes;
import com.project.ssm.repository.ChatRoomRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {
    private final ChatRoomRepository chatRoomRepository;

    public List<GetRoomListRes> getRoomList() {
        List<ChatRoom> roomList = chatRoomRepository.findAll();
        List<GetRoomListRes> roomListRes = new ArrayList<>();


        for (ChatRoom chatRoom : roomList) {
            GetRoomListRes getRoomListRes = GetRoomListRes.buildDto(chatRoom.getChatRoomName(), chatRoom.getRoomId());
            roomListRes.add(getRoomListRes);
        }

        return roomListRes;

    }

    public String createRoom(PostCreateRoomReq postCreateRoom) {
        ChatRoom room = ChatRoom.createRoom(postCreateRoom.getRoomName());
        chatRoomRepository.save(room);
         return "ok";
    }

    public GetRoomInfoRes getRoomInfo(String roomIdx) {
        Optional<ChatRoom> roomInfo = chatRoomRepository.findByRoomIdx(roomIdx);
        if (roomInfo.isPresent()) {
            return GetRoomInfoRes.buildDto(roomInfo.get().getChatRoomName());
        }
        return null;
    }
}
