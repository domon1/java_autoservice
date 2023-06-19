package com.course.project.carservice.controller;

import com.course.project.carservice.util.AutoServiceNotFoundException;
import com.course.project.carservice.util.CategoryNotFoundException;
import com.course.project.carservice.util.UserNotFoundException;
import com.course.project.carservice.util.UserRecordNotFoundException;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler({AutoServiceNotFoundException.class, CategoryNotFoundException.class,
            UserNotFoundException.class, UserRecordNotFoundException.class})
    public String notFoundException(Exception exception, Model model){
        model.addAttribute("message", exception.getMessage());
        return "notFound";
    }

    @RequestMapping("/error/999")
    public String otherError(){
        return "home";
    }
}
