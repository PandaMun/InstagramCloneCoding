package com.pandamun.instagramclonecoding.service;

import com.pandamun.instagramclonecoding.domain.UserLoginDto;
import com.pandamun.instagramclonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class UserService implements UserDetailsService {
    private final UserRepository userRepository;
    /*
        회원정보 저장
     */
    @Transactional
    public boolean save(UserLoginDto userLoginDto) {
        if(userRepository.findUserByEmail(userLoginDto.getEmail()) != null)
            return false;

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        return userRepository.save(User.builder()
                .email(userLoginDto.getEmail())
                .password(encoder.encode(userLoginDto.getPassword()))
                .phone(userLoginDto.getPhone())
                .name(userLoginDto.getName())
                .title(null)
                .website(null)
                .profileImage("/img/default_profile.jpg")
                .build());
    }

    

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
