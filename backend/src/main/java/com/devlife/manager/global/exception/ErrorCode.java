package com.devlife.manager.global.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

/**
 * 애플리케이션 전반에서 사용하는 에러 코드를 정의하는 열거형
 * - HTTP 상태 코드와 에러 메시지를 함께 관리
 * - 예외 처리의 일관성과 유지보수성을 높이기 위해 사용
 */
@Getter
public enum ErrorCode {

    EMAIL_ALREADY_EXISTS(HttpStatus.CONFLICT, "이미 존재하는 이메일입니다."),
    INVALID_INPUT(HttpStatus.BAD_REQUEST, "잘못된 입력값입니다."),
    INTERNAL_SERVER_ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "서버 내부 오류가 발생했습니다."),
    INVALID_CREDENTIALS(HttpStatus.UNAUTHORIZED, "이메일 또는 비밀번호가 올바르지 않습니다.");

    /** HTTP 상태 코드 */
    private final HttpStatus status;

    /** 에러 메시지 */
    private final String message;

    /**
     * 생성자
     *
     * @param status HTTP 상태 코드
     * @param message 에러 메시지
     */
    ErrorCode(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }
}