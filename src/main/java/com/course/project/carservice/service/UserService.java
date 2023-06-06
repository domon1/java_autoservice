package com.course.project.carservice.service;

import com.course.project.carservice.domain.Role;
import com.course.project.carservice.domain.User;
import com.course.project.carservice.repository.UserRepo;
import com.course.project.carservice.util.UserNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@Slf4j
public class UserService{
    public final UserRepo userRepo;
    public final PasswordEncoder passwordEncoder;
    public UserService(UserRepo userRepo, PasswordEncoder passwordEncoder) {
        this.userRepo = userRepo;
        this.passwordEncoder = passwordEncoder;
    }

    public boolean isUserExist(User user){
        Optional<User> dbUser = userRepo.findByUsername(user.getUsername());
        return dbUser.isEmpty();
    }

    public boolean isPhoneExist(User user){
        Optional<User> dbUser = userRepo.findByPhoneNumber(user.getPhoneNumber());
        return dbUser.isEmpty();
    }

    public boolean addUser(User user){
        if (!isUserExist(user) && !isPhoneExist(user)) {
            return false;
        }

        user.setRoles(Collections.singleton(Role.USER));
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        log.info("Generated password: " + user.getPassword());
        userRepo.save(user);

        return true;
    }

    public void editUser(String username, Map<String, String> form, Long id){
        User user = findById(id);
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());
        user.getRoles().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRoles().add(Role.valueOf(key));
            }
        }
        save(user);
    }

    public void save(User user){
        userRepo.save(user);
    }

    public User findById(Long id){
        return userRepo.findById(id)
                .orElseThrow( () -> new UserNotFoundException(id));
    }

    public List<User> findAll(){
        return userRepo.findAll();
    }
}
