package com.devlife.manager.global.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import java.util.List;

/**
 *
 * Spring Security 설정 클래스
 * - 인증 및 인가 정책 정의
 */
@Configuration @EnableWebSecurity public class SecurityConfig {
    /**
     * 보안 필터 체인 설정
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws
            Exception {
                http
                    .cors(cors -> cors.configurationSource(corsConfigurationSource())) // CORS 설정 적용
                    .csrf(csrf -> csrf.disable()) // CSRF 비활성화
                    .authorizeHttpRequests(auth -> auth
                        .requestMatchers(HttpMethod.OPTIONS, "/**").permitAll()
                        .requestMatchers("/api/auth/**").permitAll() // 인증 없이 허용
                        .anyRequest().authenticated() // 나머지는 인증 필요
                    )
                    .formLogin(form -> form.disable()) // 기본 로그인 비활성화
                    .httpBasic(httpBasic -> httpBasic.disable());
            return http.build();
    }

    /**
     * CORS(Cross-Origin Resource Sharing) 설정
     */
    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration config = new CorsConfiguration();

        config.setAllowedOrigins(List.of("http://localhost:5173"));
        config.setAllowedMethods(List.of("*"));
        config.setAllowedHeaders(List.of("*"));
        config.setAllowCredentials(true);
        config.setExposedHeaders(List.of("*"));

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/api/**", config);
        return source;
    }
}