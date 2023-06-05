package com.example.telegraphfrontend.entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
public abstract class BaseEntity {
    protected UUID id;
    @CreationTimestamp
    protected LocalDateTime createdDate;
    @UpdateTimestamp
    protected LocalDateTime updatedDate;
}
