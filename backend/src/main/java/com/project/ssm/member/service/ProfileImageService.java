package com.project.ssm.member.service;

import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.ProfileImage;
import com.project.ssm.member.repository.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProfileImageService {
    private final ProfileImageRepository profileImageRepository;

    @Value("${cloud.aws.s3.profile-bucket}")
    private String bucket;
    private final AmazonS3 s3;

    public String makeFolder() {
        String str = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd"));
        String folderPath = str.replace("/", File.separator);
        return folderPath;
    }

    public String saveFile(MultipartFile productFile) {
        String originalName = productFile.getOriginalFilename();

        String folderPath = makeFolder();
        String uuid = UUID.randomUUID().toString();
        String saveFileName = folderPath + File.separator + uuid + "_" + originalName;

        try {
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setContentLength(productFile.getSize());
            metadata.setContentType(productFile.getContentType());

            s3.putObject(bucket, saveFileName.replace(File.separator, "/"), productFile.getInputStream(), metadata);
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            // 로컬 파일 시스템에서 파일 삭제
            File localFile = new File(saveFileName);
            if (localFile.exists()) {
                localFile.delete();
            }
            return s3.getUrl(bucket, saveFileName.replace(File.separator, "/")).toString();
        }
    }

    public List<String> registerProfileImage(Member member, MultipartFile uploadFile) {
        List<String> profileImageList = new ArrayList<>();
        String saveFileName = saveFile(uploadFile);
        profileImageRepository.save(ProfileImage.createProfileImage(member, saveFileName));
        profileImageList.add(saveFileName.replace(File.separator, "/"));

        return profileImageList;
    }
}
