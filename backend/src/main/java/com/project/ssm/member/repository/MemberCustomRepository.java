package com.project.ssm.member.repository;

import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.member.model.ProfileImage;

import java.util.List;

public interface MemberCustomRepository {

    List<ProfileImage> findByMemberIdx(Long memberIdx);

    List<RoomParticipants> findChatRoomByMemberId(String memberId);


    List<RoomParticipants> findMemberNameByChatRoomName(String chatRoomId);
}
