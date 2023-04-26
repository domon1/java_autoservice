package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.service.CategoryService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("rest-category")
public class RestCategoryController {
    private final CategoryService categoryService;

    public RestCategoryController(CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<Category> findAll(){
        return categoryService.findAll();
    }

    // Для менеджера
    // TODO добавить запрос на добавление категории
    // TODO добавить запрос на удаление категории
    // TODO добавить запрос на изменение категории
}
