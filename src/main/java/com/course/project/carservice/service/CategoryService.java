package com.course.project.carservice.service;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.repository.CategoryRepo;
import com.course.project.carservice.util.CategoryNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    public void save(Category category){
        categoryRepo.save(category);
    }

    public Category findById(Long id){
        return categoryRepo.findById(id)
                .orElseThrow( () -> new CategoryNotFoundException(id));
    }

    public void delete(Long id){
        categoryRepo.deleteById(id);
    }

    public void updateCategory(Long id, Category category) {
        Category dbCategory = findById(id);
        dbCategory.setName(category.getName());
        save(dbCategory);
    }
}
