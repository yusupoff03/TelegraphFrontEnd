package com.example.telegraphfrontend.dto;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class UserRestDto {
    private String name;
    private String username;
    private String password;
}
