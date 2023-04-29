package com.course.project.carservice.controller;

import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.service.CarsService;
import com.course.project.carservice.service.RecordService;
import com.course.project.carservice.service.ServicesService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

import static java.time.format.DateTimeFormatter.ofPattern;

@Controller
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;
    private final CarsService carsService;
    private final ServicesService servicesService;

    public RecordController(RecordService recordService, CarsService carsService, ServicesService servicesService) {
        this.recordService = recordService;
        this.carsService = carsService;
        this.servicesService = servicesService;
    }

    @GetMapping
    public String record(Model model){
        LocalDate currDate = LocalDate.now();
        model.addAttribute("carMarks", carsService.findAllMark());
        model.addAttribute("locDate", currDate.format(ofPattern("yyyy-MM-dd")));
        model.addAttribute("service", servicesService.findById(1L));
        return "record";
    }

    @PostMapping
    public String newRecord(UserRecord userRecord){
        recordService.save(userRecord);
        return "redirect:/";
    }
}
