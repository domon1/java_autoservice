package com.course.project.carservice.service;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.repository.AutoServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    private final AutoServiceRepo autoServiceRepo;

    public ServicesService(AutoServiceRepo autoServiceRepo) {
        this.autoServiceRepo = autoServiceRepo;
    }

    public void addService(AutoService autoService){
        autoServiceRepo.save(autoService);
    }

    public void removeService(AutoService autoService){
        autoServiceRepo.delete(autoService);
    }

    public List<AutoService> findAll(){
        return autoServiceRepo.findAll();
    }

    public List<AutoService> findAllByCategory(Long categoryId){
        return autoServiceRepo.findAllByCategoryId(categoryId);
    }

    public AutoService findByName(String serviceName){
        return autoServiceRepo.findByName(serviceName);
    }
}
