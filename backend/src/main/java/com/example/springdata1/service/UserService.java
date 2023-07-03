package com.example.springdata1.service;

import com.example.springdata1.entity.User;

import java.util.List;


public interface UserService {
    List<User> findAll();

    User findById(Long id);

    User add(User user);

    User update(User user);

    void delete(Long id);

    User findByEmail(String email);

}
