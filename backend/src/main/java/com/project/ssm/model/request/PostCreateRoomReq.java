package com.project.ssm.model.request;

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
