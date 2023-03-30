package com.course.project.carservice.repository;

import com.course.project.carservice.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepo extends JpaRepository<Order, Long> {
}
