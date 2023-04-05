package com.course.project.carservice.service;

import com.course.project.carservice.domain.Spare;
import com.course.project.carservice.repository.SpareRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpareService {
    private final SpareRepo spareRepo;

    public SpareService(SpareRepo spareRepo) {
        this.spareRepo = spareRepo;
    }

    public List<Spare> findAll(){
        return spareRepo.findAll();
    }

    public void save(Spare spare){
        spareRepo.save(spare);
    }
}
