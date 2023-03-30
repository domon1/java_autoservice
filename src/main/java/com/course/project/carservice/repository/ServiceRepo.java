package com.course.project.carservice.repository;

import com.course.project.carservice.domain.Service;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ServiceRepo extends JpaRepository<Service, Long> {
}
