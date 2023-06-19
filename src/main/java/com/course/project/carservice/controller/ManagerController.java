package com.course.project.carservice.controller;

import com.course.project.carservice.domain.Role;
import com.course.project.carservice.service.CategoryService;
import com.course.project.carservice.service.RecordService;
import com.course.project.carservice.service.ServicesService;
import com.course.project.carservice.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    private final UserService userService;
    private final ServicesService servicesService;
    private final CategoryService categoryService;
    private final RecordService recordService;

    public ManagerController(UserService userService, ServicesService servicesService, CategoryService categoryService, RecordService recordService) {
        this.userService = userService;
        this.servicesService = servicesService;
        this.categoryService = categoryService;
        this.recordService = recordService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("users", userService.findAll());
        model.addAttribute("categories", categoryService.findAll());
        model.addAttribute("services", servicesService.findAll());
        return "/manager";
    }

    @GetMapping("user/{id}")
    public String user(@PathVariable("id") Long id, Model model){
        model.addAttribute("currUser", userService.findById(id));
        model.addAttribute("roles", Role.values());
        return "/user";
    }

    @PostMapping("/user/{id}")
    public String userEdit(@RequestParam String username, @RequestParam Map<String, String> form, @PathVariable Long id){
        userService.editUser(username, form, id);
        return "redirect:/manager";
    }

    @PostMapping("/user/password/{id}")
    public String changePassword(@RequestParam String password, @PathVariable Long id){
        userService.changePassword(password, id);
        return "redirect:/manager";
    }

    @PostMapping("/user/phone/{id}")
    public String changePhoneNumber(@RequestParam String oldPhone, @RequestParam String newPhone, @PathVariable Long id){
        recordService.updatePhone(oldPhone, newPhone);
        userService.changePhoneNumber(newPhone, id);
        return "redirect:/manager";
    }

    @GetMapping("/category/{id}")
    public String category(@PathVariable Long id, Model model){
        model.addAttribute("category", categoryService.findById(id));
        return "/category";
    }

    @GetMapping("/service/{id}")
    public String service(@PathVariable Long id, Model model){
        model.addAttribute("service", servicesService.findById(id));
        model.addAttribute("categories", categoryService.findAll());
        return "/service";
    }
}
