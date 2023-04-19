package com.course.project.carservice.controller;

import com.course.project.carservice.service.CategoryService;
import com.course.project.carservice.service.ServicesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/services")
public class ServicesController {
    private final ServicesService servicesService;
    private final CategoryService categoryService;

    public ServicesController(ServicesService servicesService, CategoryService categoryService) {
        this.servicesService = servicesService;
        this.categoryService = categoryService;
    }

    @GetMapping
    public String getCategoryList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "userCategory";
    }

    @GetMapping("{id}")
    public String getServicesList(Model model, @PathVariable Long id){
        model.addAttribute("services", servicesService.findAllByCategory(id));
        return "userServices";
    }
}
