package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.RecordingTime;
import com.course.project.carservice.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("rest-time")
public class RestRecordingTimeController {
    private final RecordService recordService;


    public RestRecordingTimeController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("{date}")
    public List<RecordingTime> getFreeTime(@PathVariable("date") LocalDate localDate){
        return recordService.getFreeTime(localDate);
    }
}
