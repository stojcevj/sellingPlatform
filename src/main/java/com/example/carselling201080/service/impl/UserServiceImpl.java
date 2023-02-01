package com.example.carselling201080.service.impl;

import com.example.carselling201080.exceptions.UserIdNotFoundException;
import com.example.carselling201080.exceptions.UserUserEmailNotFoundException;
import com.example.carselling201080.exceptions.UserUsernameNotFoundException;
import com.example.carselling201080.model.User;
import com.example.carselling201080.model.UserAuthorities;
import com.example.carselling201080.repository.UserRepository;
import com.example.carselling201080.service.UserService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public List<User> listAll() {
        return userRepository.findAll();
    }

    @Override
    public User createUser(String userFirstName,
                           String userSecondName,
                           LocalDate userBirthDay,
                           String userPhoneNumber,
                           String userEmail,
                           String userUsername,
                           String userPassword,
                           UserAuthorities userAuthorities) {
        if(!userFirstName.isEmpty() && !userSecondName.isEmpty() && !userPhoneNumber.isEmpty()
                && !userEmail.isEmpty() && !userUsername.isEmpty() && !userPassword.isEmpty()){
            return userRepository.save(new User(userFirstName, userSecondName, userBirthDay, userPhoneNumber, userEmail,userUsername, passwordEncoder.encode(userPassword), userAuthorities));
        }

        throw new IllegalArgumentException();
    }

    @Override
    public User deleteUser(Long userID) {
        User tmp = userRepository.findById(userID).orElseThrow(() -> new UserIdNotFoundException(userID));
        userRepository.delete(tmp);
        return tmp;
    }

    @Override
    public User updateUser(Long userID, String userFirstName, String userSecondName, LocalDate userBirthDay, String userPhoneNumber, String userEmail, String userUsername, String userPassword, UserAuthorities userAuthorities) {
        User tmp = userRepository.findById(userID).orElseThrow(() -> new UserIdNotFoundException(userID));

        tmp.setUserFirstName(userFirstName);
        tmp.setUserSecondName(userSecondName);
        tmp.setUserBirthDay(userBirthDay);
        tmp.setUserPhoneNumber(userPhoneNumber);
        tmp.setUserEmail(userEmail);
        tmp.setUserName(userUsername);
        tmp.setUserPassword(passwordEncoder.encode(userPassword));
        tmp.setUserAuthorities(userAuthorities);

        return userRepository.save(tmp);
    }

    @Override
    public UserDetails loadByUsername(String username) {
        return userRepository.findByUserName(username).orElseThrow(() -> new UserUsernameNotFoundException(username));
    }

    @Override
    public User loadById(Long id) {
        return userRepository.findById(id).orElseThrow(() -> new UserIdNotFoundException(id));
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        System.out.println(userRepository.findByUserEmail(s));
        return userRepository.findByUserEmail(s).orElseThrow(() -> new UserUserEmailNotFoundException(s));
    }
}
