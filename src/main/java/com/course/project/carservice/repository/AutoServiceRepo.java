package com.course.project.carservice.repository;

import com.course.project.carservice.domain.AutoService;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AutoServiceRepo extends JpaRepository<AutoService, Long> {
    List<AutoService> findAllByCategoryId(Long categoryId);
    AutoService findByName(String serviceName);
}
