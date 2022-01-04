package com.pandamun.instagramclonecoding.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Collection;

@Data
@NoArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String email;
    @JsonIgnore// json 파싱 불가
    private String password;

    private String name; //이름
    private String website; // 홈페이지
    private String phone;
    private String title;
    private String bio; // 프로필 내용
    private String profileImage;

    @Builder
    public User( String password, String email,
                String name, String website, String phone, String title,
                String bio, String profileImage) {
        this.email = email;
        this.password = password;
        this.name = name;
        this.website = website;
        this.phone = phone;
        this.title = title;
        this.bio = bio;
        this.profileImage = profileImage;
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }

}
