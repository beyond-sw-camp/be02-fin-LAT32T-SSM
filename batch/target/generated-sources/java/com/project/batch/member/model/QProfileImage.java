package com.project.batch.member.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QProfileImage is a Querydsl query type for ProfileImage
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QProfileImage extends EntityPathBase<ProfileImage> {

    private static final long serialVersionUID = 1412080597L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QProfileImage profileImage = new QProfileImage("profileImage");

    public final StringPath imageAddr = createString("imageAddr");

    public final QMember member;

    public final NumberPath<Long> profileIdx = createNumber("profileIdx", Long.class);

    public QProfileImage(String variable) {
        this(ProfileImage.class, forVariable(variable), INITS);
    }

    public QProfileImage(Path<? extends ProfileImage> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QProfileImage(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QProfileImage(PathMetadata metadata, PathInits inits) {
        this(ProfileImage.class, metadata, inits);
    }

    public QProfileImage(Class<? extends ProfileImage> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.member = inits.isInitialized("member") ? new QMember(forProperty("member")) : null;
    }

}

