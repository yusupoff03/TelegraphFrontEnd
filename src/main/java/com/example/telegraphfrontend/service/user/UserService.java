package com.example.telegraphfrontend.service.user;

import com.example.telegraphfrontend.dto.UserRestDto;
import com.example.telegraphfrontend.entity.UserEntity;

public interface UserService {
    UserEntity addUser(UserRestDto userRestDto);
    UserEntity signIn(String username,String password);
}
