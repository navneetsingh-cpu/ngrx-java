package com.ngrx.course.ngrx_backend.Repository;


import com.ngrx.course.ngrx_backend.Entity.Privilege;
import com.ngrx.course.ngrx_backend.Entity.enums.EPrivilege;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

/**
 * @author Navneet
 * @version 1.0
 * @since 2024. 06. 22.
 */

public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
    Optional<Privilege> findByName(EPrivilege name);
}
