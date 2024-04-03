package com.project.ssm.chat.service;

import com.project.ssm.chat.config.KafkaConstants;
import com.project.ssm.chat.exception.ChatRoomAccessException;
import com.project.ssm.chat.exception.ChatRoomNotFoundException;
import com.project.ssm.chat.exception.MessageAccessException;
import com.project.ssm.chat.exception.MessageNotFoundException;
import com.project.ssm.chat.model.entity.ChatRoom;
import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.chat.model.request.SendMessageReq;
import com.project.ssm.chat.model.request.UpdateMessageReq;
import com.project.ssm.chat.repository.ChatRoomRepository;
import com.project.ssm.chat.repository.MessageRepository;
import com.project.ssm.chat.repository.RoomParticipantsRepository;
import com.project.ssm.member.config.utils.JwtUtils;
import com.project.ssm.member.exception.MemberNotFoundException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.server.session.InMemoryWebSessionStore;
import org.springframework.web.server.session.WebSessionStore;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class MessageService {

    private final SimpMessagingTemplate messagingTemplate;
    private final MessageRepository messageRepository;
    private final MemberRepository memberRepository;
    private final ChatRoomRepository chatRoomRepository;
    private final RoomParticipantsRepository roomParticipantsRepository;
    private final KafkaTemplate<String, SendMessageReq> kafkaTemplate;

    @Value("${jwt.secret-key}")
    private String secretKey;

    public void sendTestMessage(String chatRoomId, SendMessageReq sendMessageReq) {
        log.info("message : {}", sendMessageReq.getMessage());
        String topic = "chat-room-" + chatRoomId;
        kafkaTemplate.send(topic, sendMessageReq);
    }

    @KafkaListener(topicPattern = "chat-room-*", groupId = "test-id")
    public void consumeMessage(SendMessageReq sendMessageReq) {
        log.info("consume-message : {}", sendMessageReq.getMessage());
        messagingTemplate.convertAndSend("/sub/room/" + sendMessageReq.getChatRoomId(), sendMessageReq);
    }



    public void sendMessage(String chatRoomId, SendMessageReq sendMessageDto) {
        if (!sendMessageDto.getMessage().isEmpty()) {

            Member member = memberRepository.findByMemberId(sendMessageDto.getMemberId()).orElseThrow(() ->
                    MemberNotFoundException.forMemberId(sendMessageDto.getMemberId()));

            ChatRoom chatRoom = chatRoomRepository.findByChatRoomId(chatRoomId).orElseThrow(() ->
                    ChatRoomNotFoundException.forNotFoundChatRoom());

            messageRepository.save(Message.createMessage(sendMessageDto.getMessage(), member, chatRoom));
            messagingTemplate.convertAndSend("/sub/room/" + chatRoomId, sendMessageDto);
        } else {
            throw MessageAccessException.forNotContent();
        }
    }

    public void updateMessage(String chatRoomId, UpdateMessageReq updateMessageReq) {
        if (!updateMessageReq.getMessage().isEmpty()) {
            List<RoomParticipants> chatRoomList = roomParticipantsRepository.findAllByMember_MemberId(updateMessageReq.getMemberId());
            for (RoomParticipants roomParticipants : chatRoomList) {
                if (roomParticipants.getChatRoom().getChatRoomId().equals(chatRoomId)) {
                    Message message = messageRepository.findById(updateMessageReq.getMessageIdx()).orElseThrow(() ->
                            MessageNotFoundException.forNotFoundMessage(updateMessageReq.getMessageIdx()));
                    message.setMessage(updateMessageReq.getMessage());
                } else {
                    throw ChatRoomAccessException.forNotAccessChatRoom(updateMessageReq.getMemberName());
                }
            }
        } else {
            throw MessageAccessException.forNotContent();
        }
    }

    public void enterRoom(String token) {
        token = JwtUtils.checkJwtToken(token);
        String memberId = JwtUtils.getMemberInfo(token, secretKey);
        messagingTemplate.convertAndSend("/sub/room", memberId);
    }
}
