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
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("username Not Found with username: " + username));
        return CourseUserDetails.build(user);
    }
}
