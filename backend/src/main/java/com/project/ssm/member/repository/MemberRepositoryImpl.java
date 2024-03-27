package com.project.ssm.member.repository;


import com.project.ssm.member.model.ProfileImage;
import com.project.ssm.member.model.QMember;
import com.project.ssm.member.model.QProfileImage;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberCustomRepository {

    private final JPAQueryFactory queryFactory;

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
}
