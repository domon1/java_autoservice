package com.course.project.carservice.controller;

import com.course.project.carservice.domain.Role;
import com.course.project.carservice.domain.User;
import com.course.project.carservice.service.CategoryService;
import com.course.project.carservice.service.ServicesService;
import com.course.project.carservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    private final UserService userService;
    private final ServicesService servicesService;
    private final CategoryService categoryService;

    public ManagerController(UserService userService, ServicesService servicesService, CategoryService categoryService) {
        this.userService = userService;
        this.servicesService = servicesService;
        this.categoryService = categoryService;
    }


    @GetMapping
    public String index(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("services", servicesService.findAll());
        return "/manager";
    }

    @GetMapping("/user/{id}")
    public String user(@PathVariable("id") Long id, Model model){
        model.addAttribute("currUser", userService.findById(id));
        model.addAttribute("roles", Role.values());
        return "/user";
    }

    @PostMapping("/user/{id}")
    public String userEdit(
            @RequestParam String username,
            @RequestParam Map<String, String> form,
            @RequestParam("id") User user
            ){
        user.setUsername(username);
        Set<String> roles = Arrays.stream(Role.values())
                .map(Role::name)
                .collect(Collectors.toSet());

        user.getRole().clear();

        for (String key : form.keySet()) {
            if (roles.contains(key)){
                user.getRole().add(Role.valueOf(key));
            }
        }

        userService.save(user);

        return "redirect:/manager";
    }
}
