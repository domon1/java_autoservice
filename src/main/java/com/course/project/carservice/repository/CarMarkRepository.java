package com.course.project.carservice.repository;

import com.course.project.carservice.domain.CarMark;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarMarkRepository extends JpaRepository<CarMark, Long> {
}
