package com.course.project.carservice.repository;

import com.course.project.carservice.domain.Category;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CategoryRepo extends JpaRepository<Category, Long> {
    Optional<Category> findById(Long id);
}
