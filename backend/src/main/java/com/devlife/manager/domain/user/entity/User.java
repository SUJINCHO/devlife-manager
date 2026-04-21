package com.devlife.manager.domain.user.entity;

import com.devlife.manager.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

/**
 * 회원 정보를 나타내는 엔티티 클래스
 * - DB 테이블과 매핑됨
 */
@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Table(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, unique = true)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String name;
}