package com.course.project.carservice.service;

import com.course.project.carservice.domain.Order;
import com.course.project.carservice.repository.OrderRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepo orderRepo;

    public OrderService(OrderRepo orderRepo) {
        this.orderRepo = orderRepo;
    }

    public List<Order> findAll(){
        return orderRepo.findAll();
    }

    public Optional<Order> findById(Long id){
        return orderRepo.findById(id);
    }
}
