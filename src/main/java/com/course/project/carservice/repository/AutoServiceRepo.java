package com.course.project.carservice.repository;

import com.course.project.carservice.domain.AutoService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AutoServiceRepo extends JpaRepository<AutoService, Long> {
    List<AutoService> findAllByCategoryId(Long categoryId);
}
