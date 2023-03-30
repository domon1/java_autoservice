package com.course.project.carservice.repository;

import com.course.project.carservice.domain.RecordingTime;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecordingTimeRepo extends JpaRepository<RecordingTime, Long> {
}
