package com.project.ssm.chat.model.request;

import lombok.*;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.List;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PostCreateRoomReq {
    @NotBlank
    @Size(max = 50)
    private String chatRoomName;
    @NotBlank
    private List<String> memberId;
}
