package com.example.telegraphfrontend.service.post;

import com.example.telegraphfrontend.entity.PostEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostService{
    @Value("${spring.user.url}")
    private String url;
    private final RestTemplate restTemplate;


    @Override
    public List<PostEntity> posts(UUID userId,int page,int size) {
     String url1=url+"/api/v1/post/my-posts/"+userId+"?page="+page+"&size="+size;
        ResponseEntity<List<PostEntity>>posts=restTemplate.exchange(
                URI.create(url1), HttpMethod.GET,null, new TypeToken<List<>>);
        return  posts.getBody();
    }
    private static <T>HttpEntity<T> getHttpEntity(T request){
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<T>entity=new HttpEntity<>(request,httpHeaders);
        return entity;
    }
}
