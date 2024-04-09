package com.project.ssm.chat.repository.querydsl;

import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.model.entity.QMessage;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport;

import java.util.List;
import java.util.stream.Collectors;

public class MessageRepositoryCustomImpl extends QuerydslRepositorySupport implements MessageRepositoryCustom {

    public MessageRepositoryCustomImpl() {
        super(Message.class);
    }

    @Override
    public List<Message> findList() {
        return null;
    }

    public Page<Message> findList(Pageable pageable, String chatRoomId) {
        QMessage message = new QMessage("message");

        List<Message> result = from(message)
                .where(message.chatRoom.chatRoomId.eq(chatRoomId))
                .orderBy(message.createdAt.desc()) // 채팅방 내역이 최신 10개가 조회 되게 수정
                .distinct()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch().stream().distinct().collect(Collectors.toList());

        return new PageImpl<>(result, pageable, pageable.getPageSize());
    }
}
