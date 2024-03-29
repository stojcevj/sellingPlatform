package com.example.sellingPlatform.model.enumerations;

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
