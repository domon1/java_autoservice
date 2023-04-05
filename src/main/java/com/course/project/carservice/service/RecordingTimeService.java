package com.course.project.carservice.service;

import com.course.project.carservice.domain.RecordingTime;
import com.course.project.carservice.repository.RecordingTimeRepo;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecordingTimeService {
    private final RecordingTimeRepo timeRepo;

    public RecordingTimeService(RecordingTimeRepo timeRepo) {
        this.timeRepo = timeRepo;
    }

    public List<RecordingTime> findAll(){
        return timeRepo.findAll();
    }
}
