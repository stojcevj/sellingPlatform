package com.example.sellingPlatform.exceptions;

public class UserUserEmailNotFoundException extends RuntimeException{
    public UserUserEmailNotFoundException(String email) {
        super("User with email:" + email + " is not found!");
    }
}