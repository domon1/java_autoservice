package com.course.project.carservice.service;

import com.course.project.carservice.domain.AutoService;
import com.course.project.carservice.repository.AutoServiceRepo;
import com.course.project.carservice.util.AutoServiceNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
public class ServicesService {
    private final AutoServiceRepo autoServiceRepo;

    public ServicesService(AutoServiceRepo autoServiceRepo) {
        this.autoServiceRepo = autoServiceRepo;
    }

    @Transactional
    public AutoService save(AutoService autoService) {
        log.info("Save autoservice with id: " + autoService.getId());
        return autoServiceRepo.save(autoService);
    }

    @Transactional
    public void delete(Long id) {
        autoServiceRepo.deleteById(id);
        log.info("Delete autoservice with id: " + id);
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

    @Transactional
    public AutoService update(Long id, AutoService autoService) {
        log.info("Update autoservice with id: " + id);
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
