package com.project.ssm.chat.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long chatRoomIdx;

    @Column(nullable = false, unique = true)
    private String chatRoomId;

    @Column(nullable = false, length = 50, unique = true)
    private String chatRoomName;

    @Column(nullable = false)
    private Boolean chatRoomStatus;

    @Column(nullable = false)
    private String startedAt;

    @Column(nullable = false)
    private String updatedAt;

    @OneToMany(mappedBy = "chatRoom")
    private List<Message> messages;

    @OneToMany(mappedBy = "chatRoom")
    private List<RoomParticipants> roomParticipantsList;

    public static ChatRoom createRoom(String roomName) {
        return ChatRoom.builder()
                .chatRoomId(UUID.randomUUID().toString())
                .chatRoomName(roomName)
                .chatRoomStatus(true)
                .startedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .updatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")))
                .build();
    }
}
