package com.project.ssm.member.repository;

import com.project.ssm.member.model.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long>{
    Optional<Member> findByMemberId(String memberId);
    Optional<Member> findByMemberName(String memberName);

}
