package com.project.ssm.search.model.request;

import com.project.ssm.search.model.response.ChatSearchRes;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ChatSearchReq {
    private String chatRoomId;
    private String message;

}
