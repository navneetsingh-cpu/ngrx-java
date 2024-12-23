package com.ngrx.course.ngrx_backend.Repository;


import com.ngrx.course.ngrx_backend.Entity.Role;
import com.ngrx.course.ngrx_backend.Entity.enums.ERole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
