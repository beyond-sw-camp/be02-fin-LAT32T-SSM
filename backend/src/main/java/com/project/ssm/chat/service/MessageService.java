package com.project.ssm.chat.service;

import com.project.ssm.chat.model.entity.ChatRoom;
import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.request.SendMessageReq;
import com.project.ssm.chat.model.request.UpdateMessageReq;
import com.project.ssm.chat.repository.ChatRoomRepository;
import com.project.ssm.chat.repository.MessageRepository;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
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

    public void sendMessage(String roomId, SendMessageReq sendMessageDto) {

        Optional<Member> member = memberRepository.findByMemberId(sendMessageDto.getMemberId());
        Optional<ChatRoom> chatRoom = chatRoomRepository.findByRoomIdx(roomId);

        if (member.isPresent() && chatRoom.isPresent()) {
            messageRepository.save(Message.createMessage(sendMessageDto.getMessage(), member.get(), chatRoom.get()));
            messagingTemplate.convertAndSend("/sub/room/" + roomId, sendMessageDto);
            
            // 반환 값으로 BaseResponse 값 반환
        } else {
            // 예외처리
        }
    }

    public void updateMessage(String roomId, UpdateMessageReq updateMessageReq) {

        // 채팅방 아이디를 통해서 사용자가 접속한 채팅방 찾기
        Optional<ChatRoom> chatRoom = chatRoomRepository.findByRoomIdx(roomId);

        // 받아온 데이터를 통해 멤버 찾기
        Optional<Member> member = memberRepository.findByMemberId(updateMessageReq.getMemberId());

        if (chatRoom.isPresent() && member.isPresent()) {
            // 해당 멤버가 작성한 메시지를 메시지 아아디를 통해서 찾기
            Optional<Message> message = messageRepository.findById(updateMessageReq.getMessageIdx());

            // 찾은 메시지를 받아온 새로운 메시지 내용으로 변경 후 저장
            if (message.isPresent()) {
                message.get().setMessage(updateMessageReq.getMessage());
            }
        }
    }
}
