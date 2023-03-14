package com.example.sellingPlatform.exceptions;

public class UserIdNotFoundException extends RuntimeException{
    public UserIdNotFoundException(Long userID) {
        super("User with ID:" + userID + " is not found!");
    }
}
