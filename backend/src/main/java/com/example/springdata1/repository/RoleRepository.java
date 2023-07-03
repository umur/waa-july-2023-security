package com.example.springdata1.repository;

import com.example.springdata1.entity.Role;
import org.springframework.data.repository.ListCrudRepository;

public interface RoleRepository extends ListCrudRepository<Role, Integer> {
    Role findOneByRole(String role);
}
