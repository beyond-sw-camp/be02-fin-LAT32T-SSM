package com.project.ssm.chat.model.entity;

import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
public class Message {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long messageIdx;

    @Column(nullable = false)
    private String message;

    @Column(nullable = false)
    private String createdAt;

    @Column(nullable = false)
    private String updatedAt;

    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    @ManyToOne
    @JoinColumn(name = "chatRoom_idx")
    private ChatRoom chatRoom;

    public static Message createMessage(String message, Member member, ChatRoom chatRoom) {
        return Message.builder()
                .message(message)
                .createdAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .member(member)
                .chatRoom(chatRoom)
                .build();
    }
}
