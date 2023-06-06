package com.course.project.carservice.service;

import com.course.project.carservice.domain.RecordingTime;
import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.repository.UserRecordRepo;
import com.course.project.carservice.util.UserRecordNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
@Transactional(readOnly = true)
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

        if (allByDate.isEmpty()){
            return times;
        } else {
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
    }

    @Transactional
    public UserRecord save(UserRecord userRecord){
        return userRecordRepo.save(userRecord);
    }

    public UserRecord findById(Long id){
        return userRecordRepo.findById(id)
                .orElseThrow(() -> new UserRecordNotFoundException(id));
    }

    public UserRecord findByUser(Long id, String phone){
        UserRecord record = findById(id);
        if (!record.getPhoneNumber().equals(phone)){
            throw new UserRecordNotFoundException(id);
        } else return record;
    }

    public List<UserRecord> findByState(String state){
        return userRecordRepo.findAllByState(state);
    }

    @Transactional
    public UserRecord updateState(Long id, String state){
        UserRecord userRecord = findById(id);
        userRecord.setState(state);
        log.info("Update record state with id: " + id + "on: " + state);
        return save(userRecord);
    }

    public List<UserRecord> findAllByUserPhone(String userPhone) {
        return userRecordRepo.findAllByPhoneNumber(userPhone);
    }
}
