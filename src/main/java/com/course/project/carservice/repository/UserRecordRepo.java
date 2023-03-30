package com.course.project.carservice.repository;

import com.course.project.carservice.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRecordRepo extends JpaRepository<UserRecord, Long> {
}
