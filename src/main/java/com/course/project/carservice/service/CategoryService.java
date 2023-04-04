package com.course.project.carservice.service;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.repository.CategoryRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public Optional<Category> findById(Long id){
        return categoryRepo.findById(id);
    }

    public void delete(Long id){
        categoryRepo.deleteById(id);
    }

}
