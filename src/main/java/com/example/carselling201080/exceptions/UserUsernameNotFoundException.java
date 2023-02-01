package com.example.carselling201080.exceptions;

public class UserUsernameNotFoundException extends RuntimeException{
    public UserUsernameNotFoundException(String Username) {
        super("User with ID:" + Username + " is not found!");
    }
}
