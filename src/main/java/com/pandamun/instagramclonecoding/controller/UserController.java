package com.pandamun.instagramclonecoding.controller;

import com.pandamun.instagramclonecoding.domain.UserLoginDto;
import com.pandamun.instagramclonecoding.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Controller
public class UserController {

    @Autowired
    UserService userService;

    //회원가입
    @PostMapping("/signup")
    public String signup(UserLoginDto userLoginDto){
        if (userService.save(userLoginDto)){
            return "redirect:/login";
        } else{
            return "redirect:/signup?error";
        }
    }

}
