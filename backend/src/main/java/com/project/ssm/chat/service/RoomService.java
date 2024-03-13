package com.project.ssm.chat.service;

import com.project.ssm.chat.model.entity.ChatRoom;
import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.chat.model.request.PostCreateRoomReq;
import com.project.ssm.chat.model.response.GetRoomInfoRes;
import com.project.ssm.chat.model.response.GetRoomListRes;
import com.project.ssm.chat.model.response.ReturnMessageRes;
import com.project.ssm.chat.repository.ChatRoomRepository;
import com.project.ssm.chat.repository.RoomParticipantsRepository;
import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

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

    @Value("${jwt.secret-key}")
    private String secretKey;

    // TODO: 멤버 아이디를 통해서 해당 사용자가 가지고 있는 채팅방 전체 조회 --> 나중에 페이징 처리 필요
    public List<GetRoomListRes> getRoomList(String token) {
        String memberId = JwtUtils.getUserMemberId(token, secretKey);
        // TODO: 조회하는 코드 변경 예정
        List<RoomParticipants> roomParticipants = roomPartRepository.findAllByMemberId(memberId);
        List<GetRoomListRes> roomListRes = new ArrayList<>();

        for (RoomParticipants roomParticipant : roomParticipants) {
            ChatRoom chatRoom = roomParticipant.getChatRoom();
            roomListRes.add(GetRoomListRes.buildDto(chatRoom.getRoomId(), chatRoom.getChatRoomName()));
        }

        return roomListRes;
    }

    // TODO: 새로운 채팅방 생성 --> @Transactional 적용하면 됨
    public String createRoom(PostCreateRoomReq postCreateRoom) {
        ChatRoom room = ChatRoom.createRoom(postCreateRoom.getRoomName());
        chatRoomRepository.save(room);

        for (String memberId : postCreateRoom.getMemberId()) {
            Optional<Member> member = memberRepository.findByMemberId(memberId);
            if (member.isPresent()) {
                RoomParticipants.buildRoomPart(member.get(), room);
            } else {

            }
        }
        return "ok";
    }

    // TODO: 채팅방 단일 조회
    public GetRoomInfoRes getRoomInfo(String roomIdx) {
        Optional<ChatRoom> roomInfo = chatRoomRepository.findByRoomIdx(roomIdx);
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
    
    // TODO: 채팅방 수정
    
    
    
    // TODO: 채팅방 삭제
}
