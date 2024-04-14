package com.project.ssm.member.service;

import com.project.ssm.chat.model.entity.RoomParticipants;
import com.project.ssm.common.BaseResponse;
import com.project.ssm.member.exception.MemberAccountException;
import com.project.ssm.member.exception.MemberDuplicateException;
import com.project.ssm.member.exception.MemberNotFoundException;
import com.project.ssm.member.model.Member;
import com.project.ssm.member.model.ProfileImage;
import com.project.ssm.member.model.request.*;
import com.project.ssm.member.model.response.*;
import com.project.ssm.member.repository.MemberRepository;
import com.project.ssm.member.repository.ProfileImageRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Slf4j
public class MemberService {

    @Value("${jwt.secret-key}")
    private String secretKey;
    @Value("${jwt.token.expired-time-ms}")
    private Long expiredTimeMs;

    private final MemberRepository memberRepository;
    private final ProfileImageRepository profileImageRepository;
    private final ProfileImageService profileImageService;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    public BaseResponse<PostMemberSignupRes> signup(PostMemberSignupReq req, MultipartFile profileImage) {
        memberRepository.findByMemberId(req.getMemberId()).ifPresent(member -> {
            throw MemberDuplicateException.forMemberId(req.getMemberId());
        });

        Member member = memberRepository.save(
                Member.createMember(req.getMemberId(), passwordEncoder.encode(req.getPassword()),
                req.getMemberName(), req.getDepartment(), req.getPosition()));
        if (profileImage != null) {
            profileImageService.registerProfileImage(member, profileImage);
        }
        return BaseResponse.successRes("MEMBER_001", true, "회원이 등록되었습니다.", PostMemberSignupRes.buildSignUpRes(member));
    }


    public BaseResponse<PostMemberLoginRes> login(PostMemberLoginReq req) {
        Member member = memberRepository.findByMemberId(req.getMemberId()).orElseThrow(() ->
                MemberNotFoundException.forMemberId(req.getMemberId()));

        if (passwordEncoder.matches(req.getPassword(), member.getPassword()) && member.getStatus().equals(true)) {
            return BaseResponse.successRes("MEMBER_002", true, "로그인에 성공하였습니다.", PostMemberLoginRes.buildLoginRes(member, secretKey, expiredTimeMs));
        } else {
            throw MemberAccountException.forInvalidPassword();
        }
    }

    public BaseResponse<String> checkId(GetMemberCheckIdReq req) {
        memberRepository.findByMemberId(req.getMemberId()).ifPresent(member -> {
            throw MemberDuplicateException.forMemberId(req.getMemberId());
        });
        return BaseResponse.successRes("MEMBER_003", true, "아이디 검사를 완료하였습니다.", "ok");
    }

    @Transactional
    public BaseResponse<String> updatePassword(Member member, PatchMemberUpdatePasswordReq req, MultipartFile profileImage) {
        Member findMember = memberRepository.findById(member.getMemberIdx()).orElseThrow(() ->
                MemberNotFoundException.forMemberIdx(member.getMemberIdx()));
        if (!passwordEncoder.matches(req.getPassword(), findMember.getPassword())) {
            throw MemberAccountException.forInvalidPassword();
        }
        else if (passwordEncoder.matches(req.getPassword(), findMember.getPassword())
                && passwordEncoder.matches(req.getNewPassword(), findMember.getPassword())) {
            throw MemberAccountException.forDifferentPassword();
        } else {
            findMember.setMemberPw(passwordEncoder.encode(req.getNewPassword()));
            findMember.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
            memberRepository.save(findMember);
            if (profileImage != null) {
                List<ProfileImage> profileImagesByMemberIdx = memberRepository.findByMemberIdx(member.getMemberIdx());
                profileImageRepository.deleteAll(profileImagesByMemberIdx);
                profileImageService.registerProfileImage(findMember, profileImage);
            }
        }
        return BaseResponse.successRes("MEMBER_004", true, "비밀번호 변경이 완료되었습니다.", "ok");
    }

    public BaseResponse<String> delete(Member m) {
        Optional<Member> byId = memberRepository.findById(m.getMemberIdx());

        if (byId.isPresent()) {
            Member member = byId.get();

            member.setStatus(false);
            member.setUpdatedAt(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss")));
            memberRepository.save(member);

            return BaseResponse.successRes("MEMBER_005", true, "회원 삭제가 정상적으로 처리되었습니다.", "ok");
        }
        return null;
    }

    // 멤버 조회를 위한 메소드
    public BaseResponse<List<GetMemberReadRes>> read(){
        List<Member> all = memberRepository.findAll();
        List<GetMemberReadRes> members = new ArrayList<>();

        for (Member member : all) {
            members.add(GetMemberReadRes.buildReadRes(member));
        }
        return BaseResponse.successRes("MEMBER_007", true, "회원조회가 성공했습니다", members);
    }

    public BaseResponse<List<GetProfileImageRes>> getMemberProfile(GetProfileImageReq getProfileImageReq) {
        Member member = memberRepository.findByMemberId(getProfileImageReq.getMemberId()).orElseThrow(() ->
                MemberNotFoundException.forMemberId(getProfileImageReq.getMemberId()));
        List<GetProfileImageRes> getProfileImageRes = new ArrayList<>();

        for (ProfileImage profileImage : member.getProfileImage()) {
            getProfileImageRes.add(GetProfileImageRes.buildProfileImage(profileImage.getImageAddr()));
        }
        return BaseResponse.successRes("CHATTING-008", true, "프로필이미지 조회가 성공했습니다.", getProfileImageRes);
    }

    public BaseResponse<List<GetChatRoomMembersRes>> getChatRoomMembers(String chatRoomId){
        List<RoomParticipants> memberNameByChatRoomInMember = memberRepository.findMemberNameByChatRoomName(chatRoomId);
        if(memberNameByChatRoomInMember.isEmpty()){
            throw MemberNotFoundException.forChatRoomId();
        }
        List<GetChatRoomMembersRes> members = new ArrayList<>();
        for (RoomParticipants roomParticipants : memberNameByChatRoomInMember) {
            members.add(GetChatRoomMembersRes.buildReadRes(roomParticipants.getMember()));
        }
        return BaseResponse.successRes("MEMBER_006",true, "채팅방 회원의 조회가 성공했습니다.", members);
    }
}
