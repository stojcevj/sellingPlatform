package com.example.sellingPlatform.model;

import org.springframework.security.core.GrantedAuthority;

public enum UserAuthorities implements GrantedAuthority {
    USER,
    ADMIN,
    MODERATOR;

    @Override
    public String getAuthority() {
        return name();
    }
}
