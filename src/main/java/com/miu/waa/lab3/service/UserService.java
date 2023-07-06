package com.miu.waa.lab3.service;

import java.util.List;

import com.miu.waa.lab3.entity.User;

public interface UserService {
    User findById(Integer id);
    User findByEmail(String email);
    List<User> findAll();
    User create(User user);
    User update(User user);
    User delete(Integer id);
}
