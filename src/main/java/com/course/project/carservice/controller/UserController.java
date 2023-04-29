package com.course.project.carservice.controller;

import com.course.project.carservice.domain.User;
import com.course.project.carservice.service.RecordService;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/personal")
public class UserController {
    private final RecordService recordService;

    public UserController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public String personalArea(@AuthenticationPrincipal User user, Model model){
        model.addAttribute("userInfo", user);
        return "personalArea";
    }

    @GetMapping("{id}")
    public String recordDetails(Model model, @PathVariable("id") Long id){
        model.addAttribute("currRecord", recordService.findById(id));
        return "currentRecord";
    }
}
