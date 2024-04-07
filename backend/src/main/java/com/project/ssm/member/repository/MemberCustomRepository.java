package com.project.ssm.member.repository;

import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.ProfileImage;

import java.util.List;

public interface MemberCustomRepository {
    /**
     * 회원 정보 수정 시 profile 이미지를 가져오기 위한 메서드
     * @param memberIdx
     * @return
     */
    List<ProfileImage> findByMemberIdx(Long memberIdx);

    List<RoomParticipants> findChatRoomByMemberId(String memberId);

    /**
     * @param chatRoomName
     * @return List<RoomParticipants>
     */
    List<RoomParticipants> findMemberNameByChatRoomName(String chatRoomName);
}
