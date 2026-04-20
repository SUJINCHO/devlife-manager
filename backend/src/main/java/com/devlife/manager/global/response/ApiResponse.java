package com.devlife.manager.global.response;

import lombok.Builder;
import lombok.Getter;

/**
 * 모든 API 응답의 공통 포맷을 정의
 * - 성공/실패 여부
 * - 데이터
 * - 메시지
 */
@Getter
@Builder
public class ApiResponse<T> {

    private boolean success;
    private T data;
    private String message;
    private String code;

    /**
     * 성공 응답 생성
     */
    public static <T> ApiResponse<T> success(T data, String message) {
        return ApiResponse.<T>builder()
                .success(true)
                .data(data)
                .message(message)
                .build();
    }

    /**
     * 성공 응답 생성(데이터 없음)
     */
    public static ApiResponse<?> success(String message) {
        return ApiResponse.builder()
                .success(true)
                .message(message)
                .build();
    }

    /**
     * 실패 응답 생성
     */
    public static ApiResponse<?> error(String code, Object data) {
        return ApiResponse.builder()
                .success(false)
                .code(code)
                .data(data)
                .build();
    }

    /**
     * 실패 응답 생성(데이터 없음)
     */
    public static ApiResponse<?> error(String code, String message) {
        return ApiResponse.builder()
                .success(false)
                .code(code)
                .message(message)
                .build();
    }
}