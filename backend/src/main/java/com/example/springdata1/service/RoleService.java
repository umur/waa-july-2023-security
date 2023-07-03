package com.example.springdata1.service;

import com.example.springdata1.entity.Role;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

public interface RoleService {
    Role findByName(String nameOfRole);
}
