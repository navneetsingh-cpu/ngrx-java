package com.ngrx.course.ngrx_backend.Repository;

import com.ngrx.course.ngrx_backend.Entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<User, Long> {
    Optional<User> findByEmail(String email);
}


