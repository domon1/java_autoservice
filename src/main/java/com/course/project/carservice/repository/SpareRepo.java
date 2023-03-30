package com.course.project.carservice.repository;

import com.course.project.carservice.domain.Spare;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpareRepo extends JpaRepository<Spare, Long> {
}
