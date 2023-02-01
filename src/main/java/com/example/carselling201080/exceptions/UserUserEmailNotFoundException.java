package com.example.carselling201080.exceptions;

public class UserUserEmailNotFoundException extends RuntimeException{
    public UserUserEmailNotFoundException(String email) {
        super("User with email:" + email + " is not found!");
    }
}