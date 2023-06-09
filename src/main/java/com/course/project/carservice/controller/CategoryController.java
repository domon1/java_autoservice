package com.course.project.carservice.controller;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.service.CategoryService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/category")
public class CategoryController {
    private final CategoryService categoryService;

    public CategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    // Все категории (permit all)
    @GetMapping
    public String getCategoryList(Model model){
        model.addAttribute("categories", categoryService.findAll());
        return "userCategory";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("newCategory")
    public String newCategory(Category category){
        categoryService.save(category);
        return "redirect:/manager";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping("{id}")
    public String editCategory(@RequestParam Long id, @ModelAttribute("category") Category category){
        categoryService.updateCategory(id, category);
        return "redirect:/manager";
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @GetMapping("delete/{id}")
    public String deleteCategory(@PathVariable("id") Long id){
        categoryService.delete(id);
        return "redirect:/manager";
    }
}
