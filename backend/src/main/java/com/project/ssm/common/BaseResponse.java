package com.project.ssm.common;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BaseResponse<T> {

    private String code;
    private Boolean isSuccess;
    private String message;
    private T result;

    public static <T>BaseResponse<T> successRes(String code, Boolean isSuccess, String message, T result) {
        return new BaseResponse<>(code, isSuccess, message, result);
    }
}
