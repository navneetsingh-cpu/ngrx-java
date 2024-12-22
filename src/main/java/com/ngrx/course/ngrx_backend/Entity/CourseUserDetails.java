package com.ngrx.course.ngrx_backend.Entity;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;


public class CourseUserDetails implements UserDetails {

    private Long id;
    private String email;
    private String password;


    public CourseUserDetails(String password, Long id, String email) {
        this.password = password;
        this.id = id;
        this.email = email;
    }

    public static CourseUserDetails build(User user) {

        return new CourseUserDetails(user.getPassword(),
                user.getId(), user.getEmail());
    }


    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return "";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        CourseUserDetails user = (CourseUserDetails) o;
        return Objects.equals(id, user.id);
    }
}