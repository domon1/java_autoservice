package com.course.project.carservice.controller;

import com.course.project.carservice.domain.UserRecord;
import com.course.project.carservice.service.CarsService;
import com.course.project.carservice.service.RecordService;
import com.course.project.carservice.service.ServicesService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("{id}")
    public String recordOn(Model model, @PathVariable Long id){
        LocalDate currDate = LocalDate.now();
        model.addAttribute("carMarks", carsService.findAllMark());
        model.addAttribute("locDate", currDate.format(ofPattern("yyyy-MM-dd")));
        model.addAttribute("service", servicesService.findById(id));
        return "someRecord";
    }

    @PreAuthorize("hasAuthority('MASTER')")
    @GetMapping("update/{id}")
    public String updateRecord(@PathVariable Long id, @RequestParam String state){
        recordService.updateState(id, state);
        return "redirect:/staff";
    }

    @PostMapping
    public String newRecord(UserRecord userRecord){
        recordService.save(userRecord);
        return "redirect:/";
    }
}
