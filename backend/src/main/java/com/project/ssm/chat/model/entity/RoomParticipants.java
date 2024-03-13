package com.project.ssm.chat.model.entity;

import com.project.ssm.member.model.Member;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoomParticipants {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long roomParticipantsIdx;

    // TODO: 멤버랑 연관관계 맺기
    @ManyToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    // TODO: 채팅방이랑 연관관계 맺기
    @ManyToOne
    @JoinColumn(name = "chatRoom_idx")
    private ChatRoom chatRoom;

    public static RoomParticipants buildRoomPart(Member member, ChatRoom chatRoom) {
        return RoomParticipants.builder()
                .member(member)
                .chatRoom(chatRoom)
                .build();
    }
}
