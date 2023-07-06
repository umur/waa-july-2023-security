package com.miu.springsecurity.repository;

import com.miu.springsecurity.entity.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepo extends CrudRepository<Role,Integer> {
    List<Role> findByRole(String role);

}
