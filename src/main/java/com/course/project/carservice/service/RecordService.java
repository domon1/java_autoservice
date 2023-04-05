package com.course.project.carservice.service;

import com.course.project.carservice.domain.User;
import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.repository.UserRecordRepo;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class RecordService {
    private final UserRecordRepo userRecordRepo;

    public RecordService(UserRecordRepo userRecordRepo) {
        this.userRecordRepo = userRecordRepo;
    }

    public List<UserRecord> findAll(){
        return userRecordRepo.findAll();
    }

    public List<UserRecord> findAllByDateAfter(LocalDate date){
        return userRecordRepo.findAllByDateAfter(date);
    }

    public List<UserRecord> findByUser(User user){
        return  userRecordRepo.findAllByUser(user);
    }

    public void save(UserRecord userRecord){
        userRecordRepo.save(userRecord);
    }

    public void updateState(UserRecord userRecord, String state){
        userRecord.setState(state);
        save(userRecord);
    }
}
