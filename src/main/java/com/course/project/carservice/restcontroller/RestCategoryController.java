package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.service.CategoryService;
import org.springframework.web.bind.annotation.*;

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
    @PostMapping
    public void createCategory(@RequestBody Category category){
        categoryService.save(category);
    }

    // TODO добавить запрос на удаление категории
    @DeleteMapping("{id}")
    public void deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
    }

    // TODO добавить запрос на изменение категории
    @PutMapping("{id}")
    public void updateCategory(@PathVariable Long id, @RequestBody Category category){
        categoryService.updateCategory(id, category);
    }
}
