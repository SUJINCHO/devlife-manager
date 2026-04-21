package com.devlife.manager.domain.user.controller;

import com.devlife.manager.domain.user.dto.request.LoginRequest;
import com.devlife.manager.domain.user.dto.request.SignUpRequest;
import com.devlife.manager.domain.user.dto.response.LoginResponse;
import com.devlife.manager.domain.user.service.AuthService;
import com.devlife.manager.global.response.ApiResponse;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 회원 관련 요청을 처리하는 컨트롤러
 * - 회원가입, 로그인 등의 API 제공
 * - 클라이언트 요청을 Service로 전달
 */
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    public ApiResponse<?> signUp(@Valid @RequestBody SignUpRequest request) {

        authService.signUp(request);

        return ApiResponse.success("회원가입 성공");
    }

    @PostMapping("/login")
    public ApiResponse<?> login(@Valid @RequestBody LoginRequest request) {

        LoginResponse response = authService.login(request);

        return ApiResponse.success(response, "로그인 성공");
    }
}