package com.project.ssm.chat.repository.querydsl;

import com.project.ssm.chat.model.entity.Message;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MessageRepositoryCustom {
    Page<Message> findList(Pageable pageable, String chatRoomId);

}
