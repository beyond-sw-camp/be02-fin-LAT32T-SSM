package com.project.batch.events.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEvent is a Querydsl query type for Event
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEvent extends EntityPathBase<Event> {

    private static final long serialVersionUID = -951283370L;

    public static final QEvent event = new QEvent("event");

    public final BooleanPath allDay = createBoolean("allDay");

    public final StringPath backgroundColor = createString("backgroundColor");

    public final StringPath closedAt = createString("closedAt");

    public final StringPath createdAt = createString("createdAt");

    public final StringPath eventContent = createString("eventContent");

    public final NumberPath<Long> eventIdx = createNumber("eventIdx", Long.class);

    public final NumberPath<Long> eventMaker = createNumber("eventMaker", Long.class);

    public final ListPath<EventParticipants, QEventParticipants> eventParticipantsList = this.<EventParticipants, QEventParticipants>createList("eventParticipantsList", EventParticipants.class, QEventParticipants.class, PathInits.DIRECT2);

    public final StringPath startedAt = createString("startedAt");

    public final StringPath textColor = createString("textColor");

    public final StringPath title = createString("title");

    public final StringPath type = createString("type");

    public final StringPath updatedAt = createString("updatedAt");

    public QEvent(String variable) {
        super(Event.class, forVariable(variable));
    }

    public QEvent(Path<? extends Event> path) {
        super(path.getType(), path.getMetadata());
    }

    public QEvent(PathMetadata metadata) {
        super(Event.class, metadata);
    }

}

