package com.course.project.carservice.repository;

import com.course.project.carservice.domain.WorkService;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkServiceRepo extends JpaRepository<WorkService, Long> {
}
