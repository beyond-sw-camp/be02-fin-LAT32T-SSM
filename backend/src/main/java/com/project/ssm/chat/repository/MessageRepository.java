package com.project.ssm.chat.repository;

import com.project.ssm.chat.model.entity.Message;
import com.project.ssm.chat.repository.querydsl.MessageRepositoryCustom;
import com.project.ssm.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long>, MessageRepositoryCustom {
    List<Message> findByMessageContaining(String keyword);
}
