package com.course.project.carservice.restcontroller;

import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.service.RecordService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("rest-record")
public class RestRecordController {
    private final RecordService recordService;

    public RestRecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping("{date}")
    public List<UserRecord> findByDate(@PathVariable("date") LocalDate localDate){
        return recordService.findAllByDate(localDate);
    }

    // Для пользователя
    // TODO добавить запрос на все записи пользователя
    // TODO добваить запрос на детализацию записи
    // TODO добавить запрос на добавиление записи
    // Для сотрудника
    // TODO добваить запрос на изменение статуса записи (обработка, выполнение, завершение)
}
