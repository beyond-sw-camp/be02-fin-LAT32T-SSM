package com.project.batch.member.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberIdx;

    @Column(nullable = false, length = 45, unique = true)
    private String memberId;

    @Column(nullable = false, length = 200)
    private String memberPw;

    @Column(nullable = false, length = 20)
    private String memberName;

    //TODO: 24.03.12 존재하는 부서만 받을 수 있게 처리 필요
    @Column(nullable = false, length = 45)
    private String department;

    //TODO: 24.03.12 존재하는 직급만 받을 수 있게 처리 필요
    @Column(nullable = false, length = 45)
    private String position;

    @Column(nullable = false)
    private String startedAt;

    @Column(nullable = false)
    private String updatedAt;


    @Column(nullable = false)
    private String authority;

    private Boolean status;

}
