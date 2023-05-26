package com.course.project.carservice.service;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.repository.AutoServiceRepo;
import com.course.project.carservice.util.AutoServiceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicesService {
    private final AutoServiceRepo autoServiceRepo;

    public ServicesService(AutoServiceRepo autoServiceRepo) {
        this.autoServiceRepo = autoServiceRepo;
    }

    public AutoService save(AutoService autoService) {
        return autoServiceRepo.save(autoService);
    }

    /* TODO ддобавить в бд скрипт каскадное удаление (set 1) */
    public void delete(Long id) {
        autoServiceRepo.deleteById(id);
    }

    public AutoService findById(Long id) {
        return autoServiceRepo.findById(id)
                .orElseThrow(() -> new AutoServiceNotFoundException(id));
    }

    public List<AutoService> findAll() {
        return autoServiceRepo.findAll();
    }

    public List<AutoService> findAllByCategory(Long categoryId) {
        return autoServiceRepo.findAllByCategoryId(categoryId);
    }

    public AutoService update(Long id, AutoService autoService) {
        return autoServiceRepo.findById(id)
                .map(service -> {
                    service.setName(autoService.getName());
                    service.setPrice(autoService.getPrice());
                    service.setDescription(autoService.getDescription());
                    service.setCategory(autoService.getCategory());
                    return autoServiceRepo.save(service);
                })
                .orElseGet(() -> {
                    autoService.setId(id);
                    return autoServiceRepo.save(autoService);
                });
    }
}
