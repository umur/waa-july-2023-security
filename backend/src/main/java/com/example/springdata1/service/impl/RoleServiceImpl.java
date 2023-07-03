package com.example.springdata1.service.impl;

import com.example.springdata1.entity.Role;
import com.example.springdata1.repository.RoleRepository;
import com.example.springdata1.service.RoleService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Transactional
@Service
public class RoleServiceImpl implements RoleService {
    
    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role findByName(String nameOfRole) {

        return roleRepository.findOneByRole(nameOfRole);
    }
}
