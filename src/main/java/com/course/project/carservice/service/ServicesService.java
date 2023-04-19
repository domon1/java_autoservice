package com.course.project.carservice.service;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.repository.AutoServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicesService {
    private final AutoServiceRepo autoServiceRepo;

    public ServicesService(AutoServiceRepo autoServiceRepo) {
        this.autoServiceRepo = autoServiceRepo;
    }

    public void save(AutoService autoService){
        autoServiceRepo.save(autoService);
    }

    /* TODO ддобавить в бд скрипт каскадное удаление (set 1) */
    public void delete(Long id){
        autoServiceRepo.deleteById(id);
    }

    public Optional<AutoService> findById(Long id){
        return autoServiceRepo.findById(id);
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
