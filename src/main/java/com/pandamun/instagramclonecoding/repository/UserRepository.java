package com.pandamun.instagramclonecoding.repository;

import com.pandamun.instagramclonecoding.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
    User findUserByEmail(String email);

}
