package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.service.RecordService;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("rest-record")
public class RestRecordController {
    private final RecordService recordService;

    public RestRecordController(RecordService recordService) {
        this.recordService = recordService;
    }


    /* TODO заменить object на ResponseEntity, добавить DTO*/

    @GetMapping("{date}")
    public List<UserRecord> findByDate(@PathVariable("date") LocalDate localDate){
        return recordService.findAllByDate(localDate);
    }

    // Для пользователя
    @PostMapping
    public void recordOnService(@RequestBody UserRecord userRecord){
        recordService.save(userRecord);
    }

    @GetMapping("{userPhone}")
    public List<UserRecord> findAllByDate(@PathVariable String userPhone){
        return recordService.findAllByUserPhone(userPhone);
    }

    @GetMapping("{recordId}")
    public UserRecord findById(@PathVariable Long recordId){
        return recordService.findById(recordId);
    }

    // Для сотрудника
    // TODO добваить preAuthorize(MASTER)
    @PutMapping("{recordId}")
    public void updateRecordState(@PathVariable Long recordId, @RequestParam("state") String state){
        recordService.updateState(recordId, state);
    }
}
