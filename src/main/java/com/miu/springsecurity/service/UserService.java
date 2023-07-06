package com.miu.springsecurity.service;

import com.miu.springsecurity.dto.UserDto;
import com.miu.springsecurity.entity.User;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(User user);
    UserDto findById(int id);
    void deleteById(int id);

}
