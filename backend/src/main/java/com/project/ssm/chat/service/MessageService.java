package com.project.ssm.chat.service;

import com.project.ssm.chat.model.entity.ChatRoom;
import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.request.SendMessageReq;
import com.project.ssm.chat.model.request.UpdateMessageReq;
import com.project.ssm.chat.repository.ChatRoomRepository;
import com.project.ssm.chat.repository.MessageRepository;
import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;
    private final ChatRoomRepository chatRoomRepository;

    @Value("${jwt.secret-key}")
    private String secretKey;

    public void sendMessage(String roomId, SendMessageReq sendMessageDto) {

        Optional<Member> member = memberRepository.findByMemberId(sendMessageDto.getMemberId());
        Optional<ChatRoom> chatRoom = chatRoomRepository.findByChatRoomId(roomId);

        if (member.isPresent() && chatRoom.isPresent()) {
            messageRepository.save(Message.createMessage(sendMessageDto.getMessage(), member.get(), chatRoom.get()));
            messagingTemplate.convertAndSend("/sub/room/" + roomId, sendMessageDto);
            
            // 반환 값으로 BaseResponse 값 반환
        } else {
            // 예외처리
        }
    }

    public void updateMessage(String roomId, UpdateMessageReq updateMessageReq) {

        Optional<ChatRoom> chatRoom = chatRoomRepository.findByChatRoomId(roomId);
        Optional<Member> member = memberRepository.findByMemberId(updateMessageReq.getMemberId());

        if (chatRoom.isPresent() && member.isPresent()) {
            Optional<Message> message = messageRepository.findById(updateMessageReq.getMessageIdx());
            if (message.isPresent()) {
                message.get().setMessage(updateMessageReq.getMessage());
            }
        }
    }

    public void enterRoom(String token) {
        if (token.startsWith("Bearer ")) {
            token = token.split(" ")[1];
            String memberId = JwtUtils.getMemberInfo(token, secretKey);
            messagingTemplate.convertAndSend("/sub/room", memberId);
        }
    }
}
