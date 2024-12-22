package com.ngrx.course.ngrx_backend.Service;


import com.ngrx.course.ngrx_backend.Entity.CourseUserDetails;
import com.ngrx.course.ngrx_backend.Entity.User;
import com.ngrx.course.ngrx_backend.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service("CourseUserDetailsService")
public class CourseUserDetailsService implements UserDetailsService {

    UserRepository userRepository;

    @Autowired
    public CourseUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("Email Not Found with email: " + email));
        return CourseUserDetails.build(user);
    }
}
