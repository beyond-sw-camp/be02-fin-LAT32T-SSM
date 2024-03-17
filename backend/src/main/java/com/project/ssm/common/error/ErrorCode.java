package com.project.ssm.common.error;

import org.springframework.http.HttpStatus;

public enum ErrorCode {
    // 공통
    INVALID_INPUT_VALUE(HttpStatus.BAD_REQUEST, "COMMON-001", "유효성 검증에 실패 하였습니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "COMMON-002", "서버에서 요청을 처리할 수 없습니다."),
    CONSTRAINT_VIOLATION(HttpStatus.BAD_REQUEST, "COMMON-003", "테이블 컬럼의 제약조건을 위반 하였습니다."),

    // 계정
    UNAUTHORIZED(HttpStatus.UNAUTHORIZED, "ACCOUNT-001", "인증에 실패 하였습니다."),
    TOKEN_NOT_EXISTS(HttpStatus.UNAUTHORIZED, "ACCOUNT-002", "토큰이 존재하지 않습니다."),
    INVALID_VERIFICATION_TOKEN(HttpStatus.UNAUTHORIZED, "ACCOUNT-003", "토큰이 유효하지 않습니다."),
    EXPIRED_VERIFICATION_TOKEN(HttpStatus.UNAUTHORIZED, "ACCOUNT-004", "토큰의 유효기간이 만료 되었습니다."),


    // 회원
    DUPLICATE_SIGNUP_ID(HttpStatus.BAD_REQUEST, "USER-001", "회원 이메일이 중복됩니다."),
    MEMBER_NOT_EXISTS(HttpStatus.NOT_FOUND, "USER-003", "회원을 찾을 수 없습니다."),
    DIFFERENT_USER_PASSWORD(HttpStatus.BAD_REQUEST, "USER-004", "비밀번호가 일치하지 않습니다."),

    // 채팅방
    DUPLICATE_CHATROOM(HttpStatus.CONFLICT, "CHATTING_001", "이미 존재하는 채팅방입니다."),
    CHATROOM_NOR_FOUND(HttpStatus.NOT_FOUND, "CHATTING_002", "찾을 수 없는 채팅방입니다."),
    DUPLICATE_ADD_MEMBER(HttpStatus.CONFLICT, "CHATTING_003", "이미 추가되었습니다."),
    ALREADY_DELETE_CHATROOM(HttpStatus.CONFLICT, "CHATTING_004", "이미 삭제된 채팅방입니다."),
    ALREADY_OUTED_CHATROOM(HttpStatus.CONFLICT, "CHATTING_005", "현재 채팅방을 나간 상태입니다."),
    NOT_ACCESS_CHATROOM(HttpStatus.FORBIDDEN, "CHATTING_006", "채팅방에 존재하지 않는 사용자입니다."),

    // 메시지
    NOT_CONTENT(HttpStatus.BAD_REQUEST, "CHATTING_007", "메시지가 없습니다."),
    REJECT_MEDIA_TYPE(HttpStatus.UNSUPPORTED_MEDIA_TYPE, "CHATTING_008", "지원하지 않는 미디어 유형입니다."),
    MESSAGE_NOT_FOUND(HttpStatus.NOT_FOUND, "CHATTING_009", "찾을 수 없는 메시지 입니다."),
    DUPLICATE_DELETE_MESSAGE(HttpStatus.CONFLICT, "CHATTING_010", "중복된 삭제 요청입니다."),
    REJECT_DELETE_MESSAGE(HttpStatus.FORBIDDEN, "CHATTING_000", "메시지를 삭제할 수 없습니다.");



    private final HttpStatus status;  // 헤더로 반환할 Http 상태 코드
    private final String code;    // 페이로드로 반환할 에러 코드
    private final String description;  // 에러 코드 문서화를 위한 설명

    ErrorCode(HttpStatus status, String code, String description) {
        this.status = status;
        this.code = code;
        this.description = description;
    }

    public HttpStatus getStatus() { return status; }

    public String getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }
}
