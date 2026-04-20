package com.devlife.manager.global.common;

import jakarta.persistence.*;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.LocalDateTime;

/**
 * 모든 엔티티의 공통 필드를 정의하는 추상 클래스
 *
 * - 생성 시간(createdAt)
 * - 수정 시간(updatedAt)
 *
 * JPA Auditing을 활용하여 엔티티의 생성 및 수정 시점을 자동으로 관리한다.
 * 이를 통해 중복 코드를 제거하고 데이터의 일관성을 유지한다.
 */
@Getter
@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
public abstract class BaseEntity {

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @LastModifiedDate
    private LocalDateTime updatedAt;


}