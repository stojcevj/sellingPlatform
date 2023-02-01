package com.example.carselling201080.exceptions;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(Long userID) {
        super("User with ID:" + userID + " is not found!");
    }
}
