package com.ngrx.course.ngrx_backend.Repository;


import com.ngrx.course.ngrx_backend.Entity.Privilege;
import com.ngrx.course.ngrx_backend.Entity.enums.EPrivilege;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;


public interface PrivilegeRepository extends CrudRepository<Privilege, Long> {
    Optional<Privilege> findByName(EPrivilege name);
}
