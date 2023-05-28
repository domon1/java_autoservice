package com.course.project.carservice.controller;

import com.course.project.carservice.service.RecordService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/staff")
public class StaffController {
    private final RecordService recordService;

    public StaffController(RecordService recordService) {
        this.recordService = recordService;
    }

    @GetMapping
    public String index(Model model){
        model.addAttribute("onCheckRecord", recordService.findByState("Ожидание"));
        model.addAttribute("onWorkRecord", recordService.findByState("Выполнение"));
        model.addAttribute("finalizeRecord", recordService.findByState("Завершен"));
        return "record";
    }

    @GetMapping("{id}")
    public String recordDetails(Model model, @PathVariable Long id){
        model.addAttribute("currRecord", recordService.findById(id));
        return "currentRecord";
    }
}
