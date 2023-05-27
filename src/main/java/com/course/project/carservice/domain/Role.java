package com.course.project.carservice.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    USER, MANAGER, MASTER, STAFF;

    @Override
    public String getAuthority() {
        return name();
    }
}
