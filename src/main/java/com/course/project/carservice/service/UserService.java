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
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {
    public final UserRepo userRepo;
    public final PasswordEncoder passwordEncoder;
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override  // add user not found exception
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

    public void save(User user){
        userRepo.save(user);
    }

    public Optional<User> findById(Long id){
        return userRepo.findById(id);
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }

    /*public List<User> findAllUser(){
        return userRepo.findByRole(Collections.singleton(Role.USER));
    }

    public List<User> findAllStaff(){
        return userRepo.findByRole(Collections.singleton(Role.STAFF));
    }

    public List<User> findAllManager(){
        return userRepo.findByRole(Collections.singleton(Role.MANAGER));
    }

    public List<User> findAllMaster(){
        return userRepo.findByRole(Collections.singleton(Role.MASTER));
    }*/
}
