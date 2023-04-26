package com.course.project.carservice.repository;

import com.course.project.carservice.domain.User;
import com.course.project.carservice.domain.UserRecord;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface UserRecordRepo extends JpaRepository<UserRecord, Long> {
    List<UserRecord> findAllByDate(LocalDate date);
    List<UserRecord> findAllByUser(User user);
}
