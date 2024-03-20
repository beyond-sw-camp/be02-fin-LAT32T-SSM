package com.project.ssm.chat.model.response;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
public class PatchUpdateRoomRes {
    @NotBlank
    private String chatRoomId;

    @NotBlank
    @Size(max = 50)
    private String chatRoomName;

    @NotBlank
    private List<String> chatMembers;

    public static PatchUpdateRoomRes buildRoom(String chatRoomId, String chatRoomName, List<String> chatMembers) {
        return PatchUpdateRoomRes.builder()
                .chatRoomId(chatRoomId)
                .chatRoomName(chatRoomName)
                .chatMembers(chatMembers)
                .build();
    }
}
