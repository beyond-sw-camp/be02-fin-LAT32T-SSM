package com.project.batch.events.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEventParticipants is a Querydsl query type for EventParticipants
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEventParticipants extends EntityPathBase<EventParticipants> {

    private static final long serialVersionUID = 533367830L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEventParticipants eventParticipants = new QEventParticipants("eventParticipants");

    public final QEvent event;

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.project.batch.member.model.QMember member;

    public QEventParticipants(String variable) {
        this(EventParticipants.class, forVariable(variable), INITS);
    }

    public QEventParticipants(Path<? extends EventParticipants> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEventParticipants(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEventParticipants(PathMetadata metadata, PathInits inits) {
        this(EventParticipants.class, metadata, inits);
    }

    public QEventParticipants(Class<? extends EventParticipants> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.event = inits.isInitialized("event") ? new QEvent(forProperty("event")) : null;
        this.member = inits.isInitialized("member") ? new com.project.batch.member.model.QMember(forProperty("member")) : null;
    }

}

