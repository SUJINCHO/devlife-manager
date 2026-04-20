package com.devlife.manager.global.exception;

import lombok.Getter;

/**
 * 비즈니스 로직에서 사용하는 커스텀 예외 클래스
 * - 에러 코드 및 메시지를 포함하여 예외 발생
 */
@Getter
public class CustomException extends RuntimeException {

    /**
     * 에러 코드 정보
     */
    private final ErrorCode errorCode;

    /**
     * ErrorCode 기반 예외 생성
     *
     * @param errorCode 정의된 에러 코드
     */
    public CustomException(ErrorCode errorCode) {
        super(errorCode.getMessage()); // 핵심 포인트
        this.errorCode = errorCode;
    }
}