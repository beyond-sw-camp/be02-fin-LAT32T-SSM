package com.project.ssm.member.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ProfileImage {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long profileIdx;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    @Column(nullable = false, length = 500)
    private String imageAddr;

    public static ProfileImage createProfileImage(Member member, String imageAddr ) {
        return ProfileImage.builder()
                .member(member)
                .imageAddr(imageAddr)
                .build();
    }
}
