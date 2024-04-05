package com.project.batch.member.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMember is a Querydsl query type for Member
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMember extends EntityPathBase<Member> {

    private static final long serialVersionUID = 1533203325L;

    public static final QMember member = new QMember("member1");

    public final StringPath authority = createString("authority");

    public final StringPath department = createString("department");

    public final StringPath memberId = createString("memberId");

    public final NumberPath<Long> memberIdx = createNumber("memberIdx", Long.class);

    public final StringPath memberName = createString("memberName");

    public final StringPath memberPw = createString("memberPw");

    public final StringPath position = createString("position");

    public final ListPath<ProfileImage, QProfileImage> profileImage = this.<ProfileImage, QProfileImage>createList("profileImage", ProfileImage.class, QProfileImage.class, PathInits.DIRECT2);

    public final StringPath startedAt = createString("startedAt");

    public final BooleanPath status = createBoolean("status");

    public final StringPath updatedAt = createString("updatedAt");

    public QMember(String variable) {
        super(Member.class, forVariable(variable));
    }

    public QMember(Path<? extends Member> path) {
        super(path.getType(), path.getMetadata());
    }

    public QMember(PathMetadata metadata) {
        super(Member.class, metadata);
    }

}

