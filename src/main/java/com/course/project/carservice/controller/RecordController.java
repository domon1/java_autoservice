package com.course.project.carservice.controller;

import com.course.project.carservice.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;

@Controller
@RequestMapping("/record")
public class RecordController {
    private final RecordService recordService;

    public RecordController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public String record(Model model){
        model.addAttribute("records", recordService.findAllByDateAfter(LocalDate.now()));
        return "record";
    }

    /*@GetMapping
    public String record(){
        return "record";
    }*/
}
