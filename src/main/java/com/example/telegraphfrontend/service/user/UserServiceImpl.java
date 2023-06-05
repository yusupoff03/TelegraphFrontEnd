package com.example.telegraphfrontend.service.user;

import com.example.telegraphfrontend.dto.UserRestDto;
import com.example.telegraphfrontend.entity.UserEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Value("${spring.user.url}")
    private String url;
    private final RestTemplate restTemplate;
    public UserEntity addUser(UserRestDto userRestDto){
        HttpEntity<UserRestDto> entity= getHttpEntity(userRestDto);
        ResponseEntity<UserEntity>add= restTemplate.exchange(URI.create(String.join("/",url,"api/v1/auth/sign-up")
        ), HttpMethod.POST, entity, UserEntity.class);
        return add.getBody();
    }

    @Override
    public UserEntity signIn(String username, String password) {
        String url1 = url+"/api/v1/auth/sign-in?password="+password+"&username="+username;
        ResponseEntity<UserEntity> signIn=restTemplate.exchange(
                URI.create(url1),
                HttpMethod.GET,null,UserEntity.class);
        if(signIn.getStatusCode()==HttpStatusCode.valueOf(401)){
            return null;
        }
        return signIn.getBody();
    }

    private static<T> HttpEntity<T> getHttpEntity(T request){
     HttpHeaders httpHeaders=new HttpHeaders();
     httpHeaders.setContentType(MediaType.APPLICATION_JSON);
     HttpEntity<T> entity=new HttpEntity<>(request,httpHeaders);
     return entity;
    }
}
