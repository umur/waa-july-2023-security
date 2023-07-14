package com.waa.lab3.service;

import com.waa.lab3.entity.User;

import java.util.List;

public interface UserService {
    String addUser(User user);

    User getById(Long id);

    List<User> getAllBy();

    String updateUser(Long id, User use);

    String deleteUser(Long id);
    User getByEmail(String email);
}
