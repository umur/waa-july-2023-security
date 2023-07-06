package com.miu.waa.lab3.repo;

import java.util.Optional;

import org.springframework.data.repository.ListCrudRepository;

import com.miu.waa.lab3.entity.Role;

public interface RoleRepo extends ListCrudRepository<Role, Integer> {
    Optional<Role> findByName(String name);
}
