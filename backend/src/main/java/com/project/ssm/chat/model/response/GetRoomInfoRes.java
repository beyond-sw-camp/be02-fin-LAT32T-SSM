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
public class GetRoomInfoRes {
    @NotBlank
    @Size(max = 50)
    private String chatRoomName;

    @NotBlank
    private List<ReturnMessageRes> messageList;

    public static GetRoomInfoRes buildDto(String roomName, List<ReturnMessageRes> messageList) {
        return GetRoomInfoRes.builder()
                .chatRoomName(roomName)
                .messageList(messageList)
                .build();
    }
}
