package com.project.ssm.chat.service;

import com.project.ssm.chat.model.entity.ChatRoom;
import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.chat.model.request.PatchUpdateRoomReq;
import com.project.ssm.chat.model.request.PostCreateRoomReq;
import com.project.ssm.chat.model.response.*;
import com.project.ssm.chat.repository.ChatRoomRepository;
import com.project.ssm.chat.repository.MessageRepository;
import com.project.ssm.chat.repository.RoomParticipantsRepository;
import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class RoomService {
    private final ChatRoomRepository chatRoomRepository;
    private final MemberRepository memberRepository;
    private final RoomParticipantsRepository roomPartRepository;
    private final MessageRepository messageRepository;

    @Value("${jwt.secret-key}")
    private String secretKey;

    // TODO: 멤버 아이디를 통해서 해당 사용자가 가지고 있는 채팅방 전체 조회 --> 나중에 페이징 처리 필요
    public List<GetRoomListRes> getRoomList(String token) {

        if (token.startsWith("Bearer ")) {
            token = token.split(" ")[1];
        }

         String memberId = JwtUtils.getUserMemberId(token, secretKey);
        // TODO: 조회하는 코드 변경 예정
        List<RoomParticipants> roomParticipants = roomPartRepository.findAllByMember_MemberId(memberId);
        List<GetRoomListRes> roomListRes = new ArrayList<>();

        if (roomParticipants.isEmpty()) {
            roomListRes.add(GetRoomListRes.buildDto("test", "test"));
            return roomListRes;
        } else {
            for (RoomParticipants roomParticipant : roomParticipants) {
                ChatRoom chatRoom = roomParticipant.getChatRoom();
                roomListRes.add(GetRoomListRes.buildDto(chatRoom.getChatRoomId(), chatRoom.getChatRoomName()));
            }
            return roomListRes;
        }
    }

    public PostCreateRoomRes createRoom(PostCreateRoomReq postCreateRoom) {
        ChatRoom room = ChatRoom.createRoom(postCreateRoom.getChatRoomIdx());
        chatRoomRepository.save(room);
        for (String memberId : postCreateRoom.getMemberId()) {
            Optional<Member> member = memberRepository.findByMemberId(memberId);
            if (member.isPresent()) {
                roomPartRepository.save(RoomParticipants.buildRoomPart(member.get(), room));
            } else {
                return null;
            }
        }
        return PostCreateRoomRes.buildRoomRes(room.getChatRoomName(), room.getChatRoomId());
    }

    public GetRoomInfoRes getRoomInfo(String roomId) {
        Optional<ChatRoom> roomInfo = chatRoomRepository.findByChatRoomId(roomId);
        List<ReturnMessageRes> messageList = new ArrayList<>();

        if (roomInfo.isPresent()) {
            List<Message> messages = roomInfo.get().getMessages();
            for (Message message : messages) {
                messageList.add(ReturnMessageRes.buildMessage(
                        message.getMessage(),
                        message.getMember().getMemberName(),
                        message.getCreatedAt()));
            }
            // 메시지 반환
            return GetRoomInfoRes.buildDto(roomInfo.get().getChatRoomName(), messageList);
        }
        return null;
    }

    public List<GetChatListRes> getChatList(String token, String chatRoomId, Integer page, Integer size) {
        List<GetChatListRes> chatList = new ArrayList<>();

        Pageable pageable = PageRequest.of(page - 1, size);
        Page<Message> list = messageRepository.findList(pageable, chatRoomId);

        for (Message message : list) {
            chatList.add(GetChatListRes.buildChatList(message.getMessage(), message.getCreatedAt(), message.getMember().getMemberName()));
        }
        return chatList;
    }

    // TODO: 채팅방 수정
    public Object updateRoom(PatchUpdateRoomReq patchUpdateRoomReq) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findByChatRoomId(patchUpdateRoomReq.getChatRoomIdx());

        if (chatRoom.isPresent()) {
            for (String memberId : patchUpdateRoomReq.getMemberId()) {
                Optional<Member> member = memberRepository.findByMemberId(memberId);
                if (member.isPresent()) {
                    roomPartRepository.save(RoomParticipants.buildRoomPart(member.get(), chatRoom.get()));
                }
            }
        }

        return null;
    }

    public DeleteRoomRes deleteChatRoom(String chatRoomId) {
        Optional<ChatRoom> chatRoom = chatRoomRepository.findByChatRoomId(chatRoomId);
        if (chatRoom.isPresent()) {
            ChatRoom findChatRoom = chatRoom.get();
            findChatRoom.setChatRoomStatus(false);
            findChatRoom.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
            chatRoomRepository.save(findChatRoom);
            return DeleteRoomRes.buildDeleteRoom(chatRoomId, findChatRoom.getUpdatedAt());
        }

        return null;
    }
}
