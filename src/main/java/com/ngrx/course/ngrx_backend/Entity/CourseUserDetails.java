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
//    private String email;
    private String password;
    private String username;
    private Collection<? extends GrantedAuthority> authorities;
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isEnabled;

    public CourseUserDetails(Collection<? extends GrantedAuthority> authorities,
                               String password, String username, Long id) {
        this.authorities = authorities;
        this.password = password;
        this.id = id;
        this.username = username;
//        this.email = email;
        this.isEnabled = true;
        this.isAccountNonExpired = true;
        this.isAccountNonLocked = true;
        this.isCredentialsNonExpired = true;
    }

    public static CourseUserDetails build(User user) {
        List<GrantedAuthority> authorities = getAuthorities(user);

        return new CourseUserDetails(authorities, user.getPassword(),
                user.getUsername(), user.getId());
    }

    public static List<GrantedAuthority> getAuthorities(User user) {

        List<GrantedAuthority> authorities = user.getRoles().stream()
                .flatMap(role -> role.getPrivileges().stream()
                        .map(privilege -> new SimpleGrantedAuthority(privilege.getName())))
                .collect(Collectors.toList());

        return authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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