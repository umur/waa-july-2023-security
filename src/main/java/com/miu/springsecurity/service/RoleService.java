package com.miu.springsecurity.service;

import com.miu.springsecurity.entity.Role;

import java.util.List;

public interface RoleService {

    List<Role> findByRole(String role);

}
