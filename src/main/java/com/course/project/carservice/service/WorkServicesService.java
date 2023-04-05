package com.course.project.carservice.service;

import com.course.project.carservice.domain.WorkService;
import com.course.project.carservice.repository.WorkServiceRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkServicesService {
    private final WorkServiceRepo workServiceRepo;

    public WorkServicesService(WorkServiceRepo workServiceRepo) {
        this.workServiceRepo = workServiceRepo;
    }

    public List<WorkService> findAll(){
        return workServiceRepo.findAll();
    }

    public void save(WorkService workService){
        workServiceRepo.save(workService);
    }
}
