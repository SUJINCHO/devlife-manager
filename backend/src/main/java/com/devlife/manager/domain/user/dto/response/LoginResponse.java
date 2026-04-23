package com.devlife.manager.domain.user.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 로그인 응답 데이터를 전달하기 위한 DTO
 */
@Getter
@AllArgsConstructor
public class LoginResponse {

    private String accessToken;
    private String tokenType;
    private long expiresIn;
}