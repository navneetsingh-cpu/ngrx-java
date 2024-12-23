package com.ngrx.course.ngrx_backend.Repository;


import com.ngrx.course.ngrx_backend.Entity.Role;
import com.ngrx.course.ngrx_backend.Entity.enums.ERole;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Navneet
 * @version 1.0
 * @since 2024. 06. 22.
 */

public interface RoleRepository extends CrudRepository<Role, Long> {
    Optional<Role> findByName(ERole name);
}
