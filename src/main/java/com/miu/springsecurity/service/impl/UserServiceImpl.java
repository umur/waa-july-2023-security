package com.miu.springsecurity.service.impl;

import com.miu.springsecurity.aspect.annotation.ExecutionTime;
import com.miu.springsecurity.dto.UserDto;
import com.miu.springsecurity.entity.User;
import com.miu.springsecurity.repository.UserRepo;
import com.miu.springsecurity.service.UserService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@PreAuthorize("hasRole('ROLE_ADMIN')")
public class UserServiceImpl implements UserService {
    private final UserRepo userRepo;
    private final ModelMapper modelMapper;


    @Override
    @ExecutionTime
    public List<UserDto> findAll() {
        var userList= (List<User>)userRepo.findAll();
        return userList.stream().map(user -> modelMapper.map(user, UserDto.class)).toList();
    }

    @Override
    @ExecutionTime
    public void save(User user) {
        userRepo.save(user);
    }

    @Override
    @ExecutionTime
    public UserDto findById(int id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    @ExecutionTime
    public void deleteById(int id) {
        userRepo.deleteById(id);
    }
}
