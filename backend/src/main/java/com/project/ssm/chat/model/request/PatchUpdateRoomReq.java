package com.project.ssm.chat.model.request;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
public class PatchUpdateRoomReq {
    private String chatRoomIdx;
    private List<String> memberId;
}
