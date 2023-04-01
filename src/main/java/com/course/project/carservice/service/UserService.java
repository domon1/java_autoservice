package com.course.project.carservice.service;

import com.course.project.carservice.domain.Role;
import com.course.project.carservice.domain.User;
import com.course.project.carservice.repository.UserRepo;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    public final UserRepo userRepo;
    public final PasswordEncoder passwordEncoder;
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepo.findByUsername(username);
    }

    public boolean isExist(User user){
        User dbUser = userRepo.findByUsername(user.getUsername());
        return dbUser == null;
    }

    public boolean addUser(User user){
        if (!isExist(user)) {
            return false;
        }

        user.setRole(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);

        return true;
    }
}
