package com.project.ssm.chat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
import com.project.ssm.notification.service.EmittersService;
import com.project.ssm.member.exception.MemberNotFoundException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.SseEmitter;

import java.io.IOException;
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
    private final KafkaTemplate<String, Object> kafkaTemplate;
    private final ObjectMapper objectMapper;
    private final EmittersService emittersService;

    @KafkaListener(topicPattern = "chat-room-.*")
    public void consumeMessage(ConsumerRecord<String, Object> record) throws JsonProcessingException {
        String message = objectMapper.writeValueAsString(record.value());
        SendMessageReq sendMessageReq = objectMapper.readValue(message, SendMessageReq.class);
        messagingTemplate.convertAndSend("/sub/room/" + sendMessageReq.getChatRoomId(), sendMessageReq);
        List<RoomParticipants> memberIdsByChatRoomName = memberRepository.findMemberNameByChatRoomName(sendMessageReq.getChatRoomId());
        if(!memberIdsByChatRoomName.isEmpty()){
            for (RoomParticipants roomParticipants : memberIdsByChatRoomName) {
                String memberId = roomParticipants.getMember().getMemberId();
                if(!memberId.equals(record.key())){
                    emittersService.sendAlarmToClients(memberId, sendMessageReq.getMemberName() +": "+ sendMessageReq.getMessage());
                }
            }
        }
    }

    public void sendMessage(String chatRoomId, SendMessageReq sendMessageDto) {
        if (!sendMessageDto.getMessage().isEmpty()) {
            Member member = memberRepository.findByMemberId(sendMessageDto.getMemberId()).orElseThrow(() ->
                    MemberNotFoundException.forMemberId(sendMessageDto.getMemberId()));

            ChatRoom chatRoom = chatRoomRepository.findByChatRoomId(chatRoomId).orElseThrow(() ->
                    ChatRoomNotFoundException.forNotFoundChatRoom());

            messageRepository.save(Message.createMessage(sendMessageDto.getMessage(), member, chatRoom));
            String topic = "chat-room-" + chatRoomId;
            kafkaTemplate.send(topic, "" + member.getMemberId().toString(), sendMessageDto);
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
}
