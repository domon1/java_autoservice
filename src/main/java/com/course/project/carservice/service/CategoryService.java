package com.course.project.carservice.service;

import com.course.project.carservice.domain.Category;
import com.course.project.carservice.repository.CategoryRepo;
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


}
