package com.course.project.carservice.service;

import com.course.project.carservice.domain.RecordingTime;
import com.course.project.carservice.domain.User;
import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.repository.UserRecordRepo;
import com.course.project.carservice.util.UserRecordNotFoundException;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class RecordService {
    private final UserRecordRepo userRecordRepo;
    private final RecordingTimeService timeService;

    public RecordService(UserRecordRepo userRecordRepo, RecordingTimeService timeService) {
        this.userRecordRepo = userRecordRepo;
        this.timeService = timeService;
    }

    public List<UserRecord> findAll(){
        return userRecordRepo.findAll();
    }

    public List<UserRecord> findAllByDate(LocalDate date){
        return userRecordRepo.findAllByDate(date);
    }

    public List<RecordingTime> getFreeTime(LocalDate date){
        List<RecordingTime> times = timeService.findAll();
        List<UserRecord> allByDate = userRecordRepo.findAllByDate(date);
        List<RecordingTime> retTimes = new ArrayList<>();

        for (UserRecord userRecord: allByDate){
            for (RecordingTime time: times){
                if (!(userRecord.getTime() == time)){
                    retTimes.add(time);
                }
            }
        }

        return retTimes;
    }

    public List<UserRecord> findByUser(User user){
        return  userRecordRepo.findAllByUser(user);
    }

    public void save(UserRecord userRecord){
        userRecordRepo.save(userRecord);
    }

    public UserRecord findById(Long id){
        return userRecordRepo.findById(id)
                .orElseThrow(() -> new UserRecordNotFoundException("UserRecord with id: " + id + " not found!"));
    }

    public void updateState(UserRecord userRecord, String state){
        userRecord.setState(state);
        save(userRecord);
    }
}
