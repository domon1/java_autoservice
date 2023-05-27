package com.course.project.carservice.util;

public class AutoServiceNotFoundException extends RuntimeException{
    public AutoServiceNotFoundException(Long id) {
        super("AutoService with id:  " + id + " not found!");
    }
}
