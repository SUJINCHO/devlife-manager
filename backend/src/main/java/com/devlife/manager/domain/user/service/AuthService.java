package com.devlife.manager.domain.user.service;

import com.devlife.manager.domain.user.dto.request.LoginRequest;
import com.devlife.manager.domain.user.dto.request.SignUpRequest;
import com.devlife.manager.domain.user.dto.response.LoginResponse;
import com.devlife.manager.domain.user.entity.User;
import com.devlife.manager.domain.user.repository.UserRepository;
import com.devlife.manager.global.exception.CustomException;
import com.devlife.manager.global.exception.ErrorCode;
import com.devlife.manager.global.security.JwtProvider;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * 회원 비즈니스 로직을 처리하는 서비스
 * - 회원 생성, 인증, 검증 등의 핵심 로직 수행
 */
@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtProvider jwtProvider;

    public LoginResponse login(LoginRequest request) {

        // 1. 사용자 조회
        // 유저 데이터 취득
        User userData = userRepository.findByEmail(request.getEmail())
                .orElseThrow(() -> new CustomException(ErrorCode.INVALID_CREDENTIALS));

        // 2. 비밀번호 검증
        if (!passwordEncoder.matches(request.getPassword(), userData.getPassword())) {
            throw new CustomException(ErrorCode.INVALID_CREDENTIALS);
        }
        // 3. JWT 생성
        String token = jwtProvider.createToken(userData.getUserId());

        // 4. 응답
        return new LoginResponse(token, "Bearer", 3600);

    }

    public void signUp(SignUpRequest request) {

        // 1. 이메일 중복 체크
        if (userRepository.existsByEmail(request.getEmail())) {
            throw new CustomException(ErrorCode.EMAIL_ALREADY_EXISTS);
        }

        // 2. 비밀번호 암호화
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // 3. 엔티티 생성
        User user = User.builder()
                .email(request.getEmail())
                .password(encodedPassword)
                .name(request.getName())
                .build();

        // 4. 저장
        userRepository.save(user);
    }
}