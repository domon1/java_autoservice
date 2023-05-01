package com.course.project.carservice.domain;

import org.springframework.security.core.GrantedAuthority;

public enum Role implements GrantedAuthority {
    ROLE_USER, ROLE_MANAGER, ROLE_MASTER, ROLE_STAFF;

    @Override
    public String getAuthority() {
        return name();
    }
}
