package com.devlife.manager.domain.task.entity;

import com.devlife.manager.domain.task.enums.Priority;
import com.devlife.manager.domain.task.enums.TaskStatus;
import com.devlife.manager.domain.user.entity.User;
import com.devlife.manager.global.common.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Builder
@AllArgsConstructor
@Table(name = "tasks")
public class Task extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long taskId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    private String title;

    @Enumerated(EnumType.STRING)
    private TaskStatus status;

    @Enumerated(EnumType.STRING)
    private Priority priority;

    private LocalDate dueDate;

    public void updateStatus(TaskStatus status) {
        this.status = status;
    }
}