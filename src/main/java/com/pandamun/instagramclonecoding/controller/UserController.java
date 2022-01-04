package com.pandamun.instagramclonecoding.controller;

import com.pandamun.instagramclonecoding.domain.UserLoginDto;
import com.pandamun.instagramclonecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public String login(){
        return "login";
    }

    //회원가입
    @PostMapping("/signup")
    public String signup(UserLoginDto userLoginDto){
        userService.save(userLoginDto);
        return "redirect:/login";
    }

}
