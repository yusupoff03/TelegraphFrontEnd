package com.example.telegraphfrontend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Column;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class PostEntity extends BaseEntity{
    private String name;
    private String title;
    private String body;
    @Column(unique = true)
    private String link;
    @JsonIgnore
    private UserEntity owner;
}
