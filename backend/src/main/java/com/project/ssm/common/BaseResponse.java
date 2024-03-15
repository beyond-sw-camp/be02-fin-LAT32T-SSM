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

    public static BaseResponse BaseResponseBuilder (String code, Boolean isSuccess, String message, Object result) {
        return BaseResponse.builder()
                .code(code)
                .isSuccess(isSuccess)
                .message(message)
                .result(result)
                .build();
    }
}
