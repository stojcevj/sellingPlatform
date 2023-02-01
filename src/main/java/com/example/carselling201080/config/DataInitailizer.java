package com.example.carselling201080.config;

import com.example.carselling201080.model.UserAuthorities;
import com.example.carselling201080.service.UserService;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.time.LocalDate;

@Component
public class DataInitailizer {
    private final UserService userService;

    public DataInitailizer(UserService userService) {
        this.userService = userService;
    }

    @PostConstruct
    void initData(){

    }
}
