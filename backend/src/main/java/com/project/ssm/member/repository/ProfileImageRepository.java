package com.project.ssm.member.repository;

import com.project.ssm.member.model.ProfileImage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfileImageRepository extends JpaRepository<ProfileImage, Long> {
}
