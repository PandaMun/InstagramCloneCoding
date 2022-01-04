package com.pandamun.instagramclonecoding.service;

import com.pandamun.instagramclonecoding.domain.User;
import com.pandamun.instagramclonecoding.domain.UserLoginDto;
import com.pandamun.instagramclonecoding.repository.UserRepository;
import lombok.RequiredArgsConstructor;
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
    //만약 이메일이 겹친다면 에러 발생
    if(userRepository.findUserByEmail(userLoginDto.getEmail())!= null) {
        return false;
    }
    //아니라면 저장
    BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
    userRepository.save(User.builder()
            .email(userLoginDto.getEmail())
            .password(encoder.encode(userLoginDto.getPassword()))
            .name(userLoginDto.getName())
            .phone(userLoginDto.getPhone())
            .title(userLoginDto.getTitle())
            .bio(null)
            .website(null)
            .profileImage(null)
            .build());
            return true;
        }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }
}
