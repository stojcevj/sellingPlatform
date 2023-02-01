package com.example.carselling201080.model;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.Collections;

@Data
@Entity
@Table(name = "userLogin")
public class User implements UserDetails {
    public User(String userFirstName, String userSecondName, LocalDate userBirthDay, String userPhoneNumber, String userEmail, String userName, String userPassword, UserAuthorities userAuthorities) {
        this.userFirstName = userFirstName;
        this.userSecondName = userSecondName;
        this.userBirthDay = userBirthDay;
        this.userPhoneNumber = userPhoneNumber;
        this.userEmail = userEmail;
        this.userName = userName;
        this.userPassword = userPassword;
        this.userAuthorities = userAuthorities;
    }

    public User(){}

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private Long userID;

    private String userFirstName;

    private String userSecondName;

    private LocalDate userBirthDay;

    private String userPhoneNumber;

    private String userEmail;

    private String userName;

    private String userPassword;

    @Enumerated(value = EnumType.STRING)
    private UserAuthorities userAuthorities;

    private boolean isAccountNonExpired = true;
    private boolean isAccountNonLocked = true;
    private boolean isCredentialsNonExpired = true;
    private boolean isEnabled = true;


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(userAuthorities);
    }

    @Override
    public String getPassword() {
        return getUserPassword();
    }

    @Override
    public String getUsername() {
        return getUserEmail();
    }

    @Override
    public boolean isAccountNonExpired() {
        return isAccountNonExpired;
    }

    @Override
    public boolean isAccountNonLocked() {
        return isAccountNonLocked;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return isCredentialsNonExpired;
    }

    @Override
    public boolean isEnabled() {
        return isEnabled;
    }
}
