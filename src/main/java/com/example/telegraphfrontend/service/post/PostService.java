package com.example.telegraphfrontend.service.post;

import com.example.telegraphfrontend.entity.PostEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.UUID;

public interface PostService {
    List<PostEntity> posts(UUID userId, int page, int size);
}
