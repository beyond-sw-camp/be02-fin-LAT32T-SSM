package com.project.ssm.model.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.UUID;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Builder
public class ChatRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomIdx;

    private String roomId;
    private String chatRoomName;

    public static ChatRoom createRoom(String roomName) {
        return ChatRoom.builder()
                .roomId(UUID.randomUUID().toString())
                .chatRoomName(roomName)
                .build();
    }
}
