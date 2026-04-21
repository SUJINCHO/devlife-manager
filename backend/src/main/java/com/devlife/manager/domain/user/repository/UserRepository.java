package com.devlife.manager.domain.user.repository;

import com.devlife.manager.domain.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 회원 엔티티에 대한 DB 접근을 담당
 * - JPA를 이용한 CRUD 처리
 */
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);
}