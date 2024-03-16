package com.project.ssm.member.model;

import com.project.ssm.calendar.model.entity.Event;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Member implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long memberIdx;

    @Column(nullable = false, length = 45, unique = true)
    private String memberId;

    @Column(nullable = false, length = 200)
    private String memberPw;

    @Column(nullable = false, length = 45)
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

    @OneToMany(mappedBy = "member")
    List<Event> events = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton((GrantedAuthority) () -> authority);
    }

    @Override
    public String getPassword() {
        return memberPw;
    }

    @Override
    public String getUsername() {
        return memberId;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
