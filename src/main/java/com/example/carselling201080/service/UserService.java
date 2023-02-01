package com.example.carselling201080.service;

import com.example.carselling201080.model.User;
import com.example.carselling201080.model.UserAuthorities;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.time.LocalDate;
import java.util.List;

public interface UserService extends UserDetailsService {

    /*
        List all Users if needed, so they can be displayed on the admin panel for the admin
    */

    List<User> listAll();

    /*
        Create user
    */

    User createUser(String userFirstName,
                    String userSecondName,
                    LocalDate userBirthDay,
                    String userPhoneNumber,
                    String userEmail,
                    String userUsername,
                    String userPassword,
                    UserAuthorities userAuthorities);
    /*
        Delete user with a given userID
    */

    User deleteUser(Long userID);

    /*
        Update user with a given userID
    */

    User updateUser(Long userID,
                    String userFirstName,
                    String userSecondName,
                    LocalDate userBirthDay,
                    String userPhoneNumber,
                    String userEmail,
                    String userUsername,
                    String userPassword,
                    UserAuthorities userAuthorities);

    /*
        Load User by Email
    */

    UserDetails loadByUsername(String email);

    /*
        Load User by ID
    */
    User loadById(Long id);
}
