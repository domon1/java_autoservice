package com.course.project.carservice.util;

public class UserRecordNotFoundException extends RuntimeException{
    public UserRecordNotFoundException(String message) {
        super(message);
    }
}
