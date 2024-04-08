package com.project.ssm.member.repository;


import com.project.ssm.chat.model.entity.QChatRoom;
import com.project.ssm.chat.model.entity.QRoomParticipants;
import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.ProfileImage;
import com.project.ssm.member.model.QMember;
import com.project.ssm.member.model.QProfileImage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory queryFactory;

    /**
     * 회원 정보 수정 시 profile 이미지를 가져오기 위한 메서드
     * @param memberIdx
     * @return
     */
    @Override
    public List<ProfileImage> findByMemberIdx(Long memberIdx) {
        QMember member = QMember.member;
        QProfileImage profileImage = QProfileImage.profileImage;

        return queryFactory
                .select(profileImage)
                .from(profileImage)
                .leftJoin(member)
                .on(profileImage.member.memberIdx.eq(member.memberIdx))
                .where(
                        profileImage.member.memberIdx.eq(memberIdx)
                )
                .fetch();
    }

    /**
     *
     * @param memberId
     * @return
     */
    @Override
    public List<RoomParticipants> findChatRoomByMemberId(String memberId) {
        QRoomParticipants roomParticipants = QRoomParticipants.roomParticipants;
        QChatRoom chatRoom = QChatRoom.chatRoom;

        return queryFactory
                .select(roomParticipants)
                .from(roomParticipants)
                .leftJoin(chatRoom)
                .on(roomParticipants.chatRoom.chatRoomIdx.eq(chatRoom.chatRoomIdx))
                .where(
                        roomParticipants.member.memberId.eq(memberId)
                )
                .fetch();
    }

    @Override
    public List<RoomParticipants> findMemberNameByChatRoomName(String chatRoomId) {
        QRoomParticipants roomParticipants = QRoomParticipants.roomParticipants;
        QChatRoom chatRoom = QChatRoom.chatRoom;
        QMember member = QMember.member;


        return queryFactory
                .select(roomParticipants)
                .from(roomParticipants)
                .leftJoin(chatRoom)
                .on(roomParticipants.chatRoom.chatRoomIdx.eq(chatRoom.chatRoomIdx))
                .leftJoin(member)
                .on(roomParticipants.member.memberIdx.eq(member.memberIdx))
                .where(
                    roomParticipants.chatRoom.chatRoomId.eq(chatRoomId)
                )
                .fetch();
    }
}
