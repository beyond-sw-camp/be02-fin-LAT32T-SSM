package com.project.ssm.search.model.response;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ChatSearchRes {
    private String memberId;
    private String message;

    public static ChatSearchRes buildChatSearch(String memberId, String message) {
        return ChatSearchRes.builder()
                .memberId(memberId)
                .message(message)
                .build();
    }
}
