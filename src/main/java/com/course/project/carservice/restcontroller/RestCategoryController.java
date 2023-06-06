package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.service.CategoryService;
import com.course.project.carservice.util.CategoryNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
    public ResponseEntity<List<Category>> findAll(){
        List<Category> all = categoryService.findAll();
        return ResponseEntity.ok(all);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PostMapping
    public ResponseEntity<HttpStatus> createCategory(@RequestBody Category category){
        categoryService.save(category);
        return ResponseEntity.ok(HttpStatus.CREATED);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @DeleteMapping("{id}")
    public ResponseEntity<HttpStatus> deleteCategory(@PathVariable Long id){
        categoryService.delete(id);
        return ResponseEntity.ok(HttpStatus.OK);
    }

    @PreAuthorize("hasAuthority('MANAGER')")
    @PutMapping("{id}")
    public ResponseEntity<Category> updateCategory(@PathVariable Long id, @RequestBody Category category){
        Category updateCategory = categoryService.updateCategory(id, category);
        return ResponseEntity.ok(updateCategory);
    }

    @ExceptionHandler
    private ResponseEntity<CategoryNotFoundException> notFound(CategoryNotFoundException e){
        return new ResponseEntity<>(e, HttpStatus.BAD_REQUEST);
    }
}
