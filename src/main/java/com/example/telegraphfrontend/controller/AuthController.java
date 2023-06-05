package com.example.telegraphfrontend.controller;

import com.example.telegraphfrontend.dto.UserRestDto;
import com.example.telegraphfrontend.entity.UserEntity;
import com.example.telegraphfrontend.service.user.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class AuthController {
    private final UserService userService;

    @GetMapping("/sign-up")
    private String signUpGet() {
        return "signUp";
    }

    @PostMapping("/sign-up")
    private String signUp(@ModelAttribute UserRestDto userRestDto, Model model) {
        model.addAttribute("user", userService.addUser(userRestDto));
        return "menu";
    }

    @GetMapping(value = "/sign-in")
    private String signInGet() {
        return "signIn";
    }

    @PostMapping(value = "/sign-in")
    private String signIn(@RequestParam String username,
                          @RequestParam String password,
                          Model model) {
        UserEntity user=userService.signIn(username, password);
        if(user==null){
            model.addAttribute("message","Invalid username or password");
            return "signIn";
        }
        model.addAttribute("user", user);
        return "menu";
    }

}
