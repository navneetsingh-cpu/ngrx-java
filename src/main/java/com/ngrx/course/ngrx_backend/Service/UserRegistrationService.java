package com.ngrx.course.ngrx_backend.Service;


import com.ngrx.course.ngrx_backend.Entity.Role;
import com.ngrx.course.ngrx_backend.Entity.User;
import com.ngrx.course.ngrx_backend.Entity.enums.ERole;
import com.ngrx.course.ngrx_backend.Repository.RoleRepository;
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
    RoleRepository roleRepository;
    PasswordEncoder passwordEncoder;

    @Autowired
    public UserRegistrationService(UserRepository userRepository, RoleRepository roleRepository,
                                   PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(UserRegistrationDTO registrationDTO) {
        Role role = roleRepository.findByName(ERole.ROLE_USER).get();

        User user = new User(registrationDTO.getUsername(),
                passwordEncoder.encode(registrationDTO.getPassword()), new HashSet<>(Arrays.asList(role)));

        userRepository.save(user);
    }

}
