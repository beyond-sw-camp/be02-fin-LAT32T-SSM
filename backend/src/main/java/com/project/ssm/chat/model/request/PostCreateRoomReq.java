package com.project.ssm.chat.model.request;

import lombok.*;

import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRoomReq {
    private String chatRoomName;
    private List<String> memberId;
}
