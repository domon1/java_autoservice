package com.course.project.carservice.service;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.repository.CategoryRepo;
import com.course.project.carservice.util.CategoryNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class CategoryService {

    private final CategoryRepo categoryRepo;

    public CategoryService(CategoryRepo categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    public List<Category> findAll(){
        return categoryRepo.findAll();
    }

    @Transactional
    public Category save(Category category){
        log.info("Save category with id: " + category.getId());
        return categoryRepo.save(category);
    }

    public Category findById(Long id){
        return categoryRepo.findById(id)
                .orElseThrow( () -> new CategoryNotFoundException(id));
    }

    @Transactional
    public void delete(Long id){
        categoryRepo.deleteById(id);
        log.info("Delete category with id: " + id);
    }

    @Transactional
    public Category updateCategory(Long id, Category category) {
        log.info("Update category with id: " + category.getId());
        return categoryRepo.findById(id)
                .map(category1 -> {
                    category1.setName(category.getName());
                    return save(category1);
                })
                .orElseGet(() -> {
                    category.setId(id);
                    return save(category);
                });
    }
}
