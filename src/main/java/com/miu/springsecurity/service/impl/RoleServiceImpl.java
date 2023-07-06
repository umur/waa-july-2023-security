package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.entity.Role;
import com.miu.springsecurity.repository.RoleRepo;
import com.miu.springsecurity.service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements RoleService {
    private final RoleRepo roleRepo;



    @Override
    public List<Role> findByRole(String role) {
        return roleRepo.findByRole("USER");

    }


}
