package com.course.project.carservice.controller;

import com.course.project.carservice.domain.User;
import com.course.project.carservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/register")
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String registrationForm(){
        return "registration";
    }

    @PostMapping
    public String registration(@Validated User user){
        if (userService.addUser(user)){
            return "redirect:login";
        }
        return "redirect:/register";
    }

}
