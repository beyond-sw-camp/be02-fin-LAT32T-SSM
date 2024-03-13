package com.project.ssm.chat.model.request;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRoomReq {
    private String username;
    private String roomName;
}
