package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Builder
@Getter
@Setter
public class PatchUpdateRoomRes {
    private String chatRoomId;
    private String chatRoomName;
    private List<String> chatMembers;
}
