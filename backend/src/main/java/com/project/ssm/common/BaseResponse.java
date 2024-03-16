package com.project.ssm.common;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse {

    private String code;
    private Boolean isSuccess;
    private String message;
    private Object result;
}
