package com.course.project.carservice.util;

public class UserRecordNotFoundException extends RuntimeException{
    public UserRecordNotFoundException(Long id) {
        super("UserRecord with id: " + id + " not found!");
    }
}
