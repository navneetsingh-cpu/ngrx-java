package com.ngrx.course.ngrx_backend.Service;


import com.ngrx.course.ngrx_backend.Entity.User;
import com.ngrx.course.ngrx_backend.Repository.UserRepository;
import com.ngrx.course.ngrx_backend.dto.UserRegistrationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@Service
public class UserRegistrationService {

    UserRepository userRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserRepository userRepository,
                                   PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserRegistrationDTO registrationDTO) {

        User user = new User(registrationDTO.getEmail(),
                passwordEncoder.encode(registrationDTO.getPassword()));

        userRepository.save(user);
    }

}
